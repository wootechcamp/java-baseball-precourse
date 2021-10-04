package baseball.domain;

import baseball.exception.IllegalInputValueException;
import java.util.ArrayList;
import java.util.List;

public class Pitcher {

    public Balls throwBalls(final String inputValue) {
        return new Balls(parseBalls(split(inputValue)));
    }

    private String[] split(final String inputValue) {
        final String[] dividedValues = inputValue.split("");

        verifyInputValuesLength(dividedValues);

        return dividedValues;
    }

    private List<Ball> parseBalls(final String[] inputValues) {
        final List<Ball> balls = new ArrayList<>();

        for (int index = 0; index < inputValues.length; index++) {
            balls.add(new Ball(new BallPosition(index), new BallNumber(parseInt(inputValues[index]))));
        }

        return balls;
    }

    private int parseInt(final String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalInputValueException("숫자를 입력해주세요.");
        }
    }

    private void verifyInputValuesLength(String[] dividedValues) {
        if (dividedValues.length > Balls.BALLS_SIZE) {
            throw new IllegalInputValueException("3자리의 숫자를 입력해주세요.");
        }
    }
}
