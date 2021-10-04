package baseball.domain;

import java.util.Objects;

public class Ball {
    private final BallPosition position;
    private final BallNumber number;

    public Ball(final BallPosition position, final BallNumber number) {
        this.position = position;
        this.number = number;
    }

    public BallPosition getBallPosition() {
        return position;
    }

    public BallNumber getBallNumber() {
        return number;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
