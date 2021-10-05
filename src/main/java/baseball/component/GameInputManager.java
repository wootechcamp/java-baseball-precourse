package baseball.component;

import baseball.enums.GameStatus;
import baseball.exception.IllegalInputValueException;
import nextstep.utils.Console;

import java.text.MessageFormat;

public class GameInputManager {
    private final GameOutputManager outputManager;

    public GameInputManager(final GameOutputManager outputManager) {
        this.outputManager = outputManager;
    }

    public String insertNumbers(final GameStatus gameStatus) {
        outputManager.printGameMessage(gameStatus);
        return Console.readLine();
    }

    public String insertStatus(final GameStatus gameStatus) {
        outputManager.printGameMessage(gameStatus);

        String status = Console.readLine();

        while (!GameStatus.isChooseStatus(status)) {
            verifyInsertStatus(status);
            status = Console.readLine();
        }

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
            outputManager.printErrorMessage(e);
        }
    }
}
