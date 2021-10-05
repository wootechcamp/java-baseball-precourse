package baseball.domain;

import baseball.exception.IllegalInputValueException;

public class Pitcher {

    public Balls throwBalls(final String inputValue) {
        return Balls.convert(split(inputValue));
    }

    private String[] split(final String inputValue) {
        final String[] dividedValues = inputValue.split("");

        verifyInputValue(dividedValues);

        return dividedValues;
    }

    private void verifyInputValue(final String[] dividedValues) {
        if (isNotEqualBallSize(dividedValues)) {
            throw new IllegalInputValueException("3자리의 숫자를 입력해 주세요.");
        }

        if (isAlreadyExistNumber(dividedValues)) {
            throw new IllegalInputValueException("같은 숫자는 입력 할 수 없습니다.");
        }
    }

    private boolean isNotEqualBallSize(String[] dividedValues) {
        return dividedValues.length != Balls.BALLS_SIZE;
    }

    private boolean isAlreadyExistNumber(final String[] dividedValues) {
        boolean isAlreadyExist = false;

        for (int index = 0; index < dividedValues.length; index++) {
            isAlreadyExist |= hasSameNumber(dividedValues, index);
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
