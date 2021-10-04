package baseball.domain;

import baseball.exception.BallNumberOutOfRangeException;
import java.util.Objects;

public class BallNumber {
    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 9;

    private final int number;

    public BallNumber(final int number) {
        verifyBallNumber(number);

        this.number = number;
    }

    private void verifyBallNumber(final int number) {
        if (!(number >= MINIMUM_NUMBER && number <= MAXIMUM_NUMBER)) {
            throw new BallNumberOutOfRangeException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BallNumber)) {
            return false;
        }
        BallNumber that = (BallNumber)o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
