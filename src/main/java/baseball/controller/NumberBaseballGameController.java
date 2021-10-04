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

    private void round() {
        try {
            viewer.printGameMessage(gameStatus);

            final BallStatuses ballStatuses = referee.judge(computerBalls, pitcher.throwBalls(insertNumbers()));

            viewer.render(ballStatuses);

            completeGame(ballStatuses);
            chooseGameContinueOrNot();
        } catch (BaseballRuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private void completeGame(BallStatuses ballStatuses) {
        if (!ballStatuses.isCompleted()) {
            return;
        }

        gameStatus = GameStatus.COMPLETE;
    }

    private void chooseGameContinueOrNot() {
        if (!GameStatus.COMPLETE.equals(gameStatus)) {
            return;
        }

        viewer.printGameMessage(gameStatus);
        final String status = insertStatus();

        restartGame(status);
        terminateGame(status);
    }

    private void prepareBalls() {
        computerBalls = computer.prepareBalls();
    }

    private void restartGame(final String status) {
        if (!GameStatus.RESTART.getStatus().equals(status)) {
            return;
        }

        gameStatus = GameStatus.RESTART;
        prepareBalls();
    }

    private void terminateGame(final String status) {
        if (!GameStatus.TERMINATE.getStatus().equals(status)) {
            return;
        }

        gameStatus = GameStatus.TERMINATE;
        viewer.printGameMessage(gameStatus);
    }

    private String insertNumbers() {
        return Console.readLine();
    }

    private String insertStatus() {
        final String status = Console.readLine();

        if (!GameStatus.isChooseStatus(status)) {
            throw new IllegalInputValueException(
                MessageFormat.format("{0}이나 {1}의 숫자만 입력하세요.",
                    GameStatus.RESTART.getStatus(),
                    GameStatus.TERMINATE.getStatus()
                )
            );
        }

        return status;
    }
}
