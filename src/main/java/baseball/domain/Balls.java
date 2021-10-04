package baseball.domain;

import baseball.exception.CannotMakeBallsException;
import java.util.ArrayList;
import java.util.List;

public class Balls {
    public static final int BALLS_SIZE = BallPosition.ALLOW_POSITIONS.size();

    private int index;
    private final List<Ball> balls = new ArrayList<>();

    public Balls(final Ball ball) {
        addBall(ball);
    }

    public Balls(final List<Ball> balls) {
        verifyBalls(balls);

        this.balls.addAll(balls);
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

    private void verifyBalls(final List<Ball> balls) {
        if (balls.size() > BALLS_SIZE) {
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
