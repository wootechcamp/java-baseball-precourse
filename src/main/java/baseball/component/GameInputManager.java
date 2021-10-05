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
        String numbers;
        do {
            outputManager.printGameMessage(gameStatus);
            numbers = Console.readLine();

            verifyInsertNumbers(numbers);
        } while (isAlreadyExistNumber(numbers));

        return numbers;
    }

    public String insertStatus(final GameStatus gameStatus) {
        String status;
        do {
            outputManager.printGameMessage(gameStatus);
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
            outputManager.printErrorMessage(e);
        }
    }

    private void verifyInsertNumbers(final String numbers) {
        if (!isAlreadyExistNumber(numbers)) {
            return;
        }

        try {
            throw new IllegalInputValueException("같은 숫자는 입력 할 수 없습니다.");
        } catch (IllegalInputValueException e) {
            outputManager.printErrorMessage(e);
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
}
