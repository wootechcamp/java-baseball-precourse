package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.Computer;
import baseball.domain.Pitcher;
import baseball.domain.Referee;
import baseball.enums.BallStatuses;
import baseball.enums.GameStatus;
import baseball.exception.BaseballRuntimeException;

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
            final String inputValue = viewer.insertNumbers(gameStatus);
            final BallStatuses ballStatuses = referee.judge(computerBalls, pitcher.throwBalls(inputValue));

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

        final String status = viewer.insertStatus(gameStatus);

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

    private void changeGameStatus(final GameStatus status) {
        gameStatus = status;
    }
}
