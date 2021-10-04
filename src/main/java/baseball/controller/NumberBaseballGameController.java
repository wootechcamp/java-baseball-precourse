package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.Computer;
import baseball.domain.Pitcher;
import baseball.domain.Referee;
import baseball.enums.BallStatuses;
import baseball.enums.GameStatus;
import baseball.exception.BaseballRuntimeException;
import baseball.exception.IllegalInputValueException;
import java.text.MessageFormat;
import nextstep.utils.Console;

public class NumberBaseballGameController {
    private static GameStatus gameStatus = GameStatus.START;
    private static Balls computerBalls;

    private final Referee referee;
    private final Computer computer;
    private final Pitcher pitcher;
    private final NumberBaseballGameViewer viewer;

    public NumberBaseballGameController(final Referee referee, final Computer computer, final Pitcher pitcher,
        final NumberBaseballGameViewer viewer) {
        init();

        this.referee = referee;
        this.computer = computer;
        this.pitcher = pitcher;
        this.viewer = viewer;
    }

    public void start() {
        prepareBalls();

        while (GameStatus.isContinuable(gameStatus)) {
            round();
        }
    }

    private void init() {
        changeGameStatus(GameStatus.START);
    }

    private void round() {
        try {
            final BallStatuses ballStatuses = referee.judge(computerBalls, pitcher.throwBalls(insertNumbers()));

            viewer.printGameResult(ballStatuses);

            completeGame(ballStatuses);
        } catch (BaseballRuntimeException e) {
            viewer.printErrorMessage(e);
        }
    }

    private void completeGame(final BallStatuses ballStatuses) {
        if (!ballStatuses.isCompleted()) {
            return;
        }

        changeGameStatus(GameStatus.COMPLETE);
        chooseGameContinueOrNot();
    }

    private void chooseGameContinueOrNot() {
        if (!GameStatus.COMPLETE.match(gameStatus)) {
            return;
        }

        final String status = insertStatus();

        restartGame(status);
        terminateGame(status);
    }

    private void restartGame(final String status) {
        if (!GameStatus.RESTART.match(status)) {
            return;
        }

        changeGameStatus(GameStatus.RESTART);

        prepareBalls();
    }

    private void terminateGame(final String status) {
        if (!GameStatus.TERMINATE.getStatus().equals(status)) {
            return;
        }

        changeGameStatus(GameStatus.TERMINATE);
    }

    private void prepareBalls() {
        computerBalls = computer.prepareBalls();
    }

    private String insertNumbers() {
        String numbers;
        do {
            viewer.printGameMessage(gameStatus);
            numbers = Console.readLine();

            verifyInsertNumbers(numbers);
        } while (isAlreadyExistNumber(numbers));

        return numbers;
    }

    private String insertStatus() {
        String status;
        do {
            viewer.printGameMessage(gameStatus);
            status = Console.readLine();

            verifyInsertStatus(status);
        } while (!GameStatus.isChooseStatus(status));

        return status;
    }

    private void verifyInsertStatus(final String status) {
        if (GameStatus.isChooseStatus(status)) {
            return;
        }

        try {
            throw new IllegalInputValueException(MessageFormat.format("{0}이나 {1}의 값을 입력해주세요.",
                GameStatus.RESTART.getStatus(), GameStatus.TERMINATE.getStatus()));
        } catch (IllegalInputValueException e) {
            viewer.printErrorMessage(e);
        }
    }

    private void verifyInsertNumbers(final String numbers) {
        if (!isAlreadyExistNumber(numbers)) {
            return;
        }

        try {
            throw new IllegalInputValueException("같은 숫자는 입력 할 수 없습니다.");
        } catch (IllegalInputValueException e) {
            viewer.printErrorMessage(e);
        }
    }

    private boolean isAlreadyExistNumber(String numbers) {
        boolean isAlreadyExist = false;
        final String[] dividedNumbers = numbers.split("");

        for (int index = 0; index < dividedNumbers.length; index++) {
            isAlreadyExist |= hasSameNumber(dividedNumbers, index);
        }

        return isAlreadyExist;
    }

    private boolean hasSameNumber(String[] dividedNumbers, int index) {
        if (index == dividedNumbers.length - 1) {
            return false;
        }
        return dividedNumbers[index].equals(dividedNumbers[index + 1]);
    }

    private void changeGameStatus(final GameStatus status) {
        gameStatus = status;
    }
}
