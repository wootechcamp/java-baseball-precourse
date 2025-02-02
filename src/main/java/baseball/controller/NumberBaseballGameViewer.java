package baseball.controller;

import baseball.component.GameInputManager;
import baseball.component.GameOutputManager;
import baseball.enums.BallStatuses;
import baseball.enums.GameStatus;
import baseball.exception.BaseballRuntimeException;

public class NumberBaseballGameViewer {
    private final GameInputManager inputManager;
    private final GameOutputManager outputManager;

    public NumberBaseballGameViewer(final GameOutputManager outputManager) {
        this.inputManager = new GameInputManager(outputManager);
        this.outputManager = outputManager;
    }

    public String insertNumbers(final GameStatus gameStatus) {
        return inputManager.insertNumbers(gameStatus);
    }

    public String insertStatus(final GameStatus gameStatus) {
        return inputManager.insertStatus(gameStatus);
    }

    public void printGameResult(final BallStatuses ballStatuses) {
        outputManager.printGameResult(ballStatuses);
    }

    public void printErrorMessage(BaseballRuntimeException e) {
        outputManager.printErrorMessage(e);
    }
}
