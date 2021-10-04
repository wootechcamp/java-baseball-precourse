package baseball.domain;

import baseball.exception.IllegalInputValueException;

public class Pitcher {

    public Balls throwBalls(final String inputValue) {
        return Balls.convert(split(inputValue));
    }

    private String[] split(final String inputValue) {
        final String[] dividedValues = inputValue.split("");

        verifyInputValuesLength(dividedValues);

        return dividedValues;
    }

    private void verifyInputValuesLength(final String[] dividedValues) {
        if (dividedValues.length != Balls.BALLS_SIZE) {
            throw new IllegalInputValueException("3자리의 숫자를 입력해 주세요.");
        }
    }
}
