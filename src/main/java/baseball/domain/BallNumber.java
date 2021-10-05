package baseball.domain;

import baseball.exception.BallNumberOutOfRangeException;
import baseball.exception.IllegalInputValueException;
import java.util.Objects;

public class BallNumber {
    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 9;

    private final int number;

    public BallNumber(final int number) {
        verifyBallNumber(number);

        this.number = number;
    }

    public static BallNumber convert(final String inputValue) {
        try {
            return new BallNumber(Integer.parseInt(inputValue));
        } catch (NumberFormatException e) {
            throw new IllegalInputValueException("숫자 만 입력해 주세요.");
        }
    }

    private void verifyBallNumber(final int number) {
        if (!(number >= MINIMUM_NUMBER && number <= MAXIMUM_NUMBER)) {
            throw new BallNumberOutOfRangeException();
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BallNumber)) {
            return false;
        }
        final BallNumber that = (BallNumber)o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
