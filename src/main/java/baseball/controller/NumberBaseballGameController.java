package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.Computer;
import baseball.domain.Pitcher;
import baseball.domain.Referee;
import baseball.enums.BallStatuses;
import baseball.enums.GameStatus;
import baseball.exception.BaseballRuntimeException;
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
            final BallStatuses ballStatuses = referee.judge(computerBalls, pitcher.throwBalls(insertNumbers()));

            viewer.printGameResult(ballStatuses);

            completeGame(ballStatuses);
        } catch (BaseballRuntimeException e) {
            System.out.println(e.getMessage());
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

        viewer.printGameMessage(gameStatus);
    }

    private void prepareBalls() {
        computerBalls = computer.prepareBalls();
    }

    private String insertNumbers() {
        viewer.printGameMessage(gameStatus);

        return Console.readLine();
    }

    private String insertStatus() {
        viewer.printGameMessage(gameStatus);

        final String status = Console.readLine();

        if (GameStatus.isChooseStatus(status)) {
            return status;
        }

        return insertStatus();
    }

    private void changeGameStatus(final GameStatus status) {
        gameStatus = status;
    }
}
