package baseball.domain;

import baseball.exception.CannotMakeBallsException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Balls {
    public static final int BALLS_SIZE = BallPosition.ALLOW_POSITIONS.size();

    private int index;
    private final List<Ball> balls;

    public Balls(final Ball... balls) {
        verifyBalls(balls);

        this.balls = new ArrayList<>(Arrays.asList(balls));
        this.index = this.balls.size();
    }

    public int getIndex() {
        return index;
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public void addBall(final Ball ball) {
        if (isNotAvailableAddingBall(ball)) {
            return;
        }

        balls.add(ball);
        increaseIndex();
    }

    private void increaseIndex() {
        this.index += 1;
    }

    private void verifyBalls(final Ball... balls) {
        if (balls.length > BALLS_SIZE) {
            throw new CannotMakeBallsException();
        }
    }

    private boolean isNotAvailableAddingBall(final Ball ball) {
        return balls.contains(ball);
    }

    public boolean isContinuableAddingBall() {
        return balls.size() < BALLS_SIZE;
    }
}
