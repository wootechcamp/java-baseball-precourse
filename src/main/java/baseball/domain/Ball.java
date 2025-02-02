package baseball.domain;

import java.util.Objects;

public class Ball {
    private final BallPosition position;
    private final BallNumber number;

    public Ball(final BallPosition position, final BallNumber number) {
        this.position = position;
        this.number = number;
    }

    public BallPosition getPosition() {
        return position;
    }

    public BallNumber getNumber() {
        return number;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ball)) {
            return false;
        }
        final Ball ball = (Ball)o;
        return number.equals(ball.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
