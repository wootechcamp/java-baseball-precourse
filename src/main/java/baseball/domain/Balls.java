package baseball.domain;

import baseball.exception.BallsSizeOutOfIndexException;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    public static final int BALLS_SIZE = BallPosition.ALLOW_POSITIONS.size();

    private final List<Ball> balls = new ArrayList<>();

    public Balls(final Ball ball) {
        addBall(ball);
    }

    public Balls(final List<Ball> balls) {
        verifyBalls(balls);

        this.balls.addAll(balls);
    }

    public static Balls convert(final String[] inputValues) {
        final List<Ball> balls = new ArrayList<>();

        for (int index = 0; index < inputValues.length; index++) {
            balls.add(new Ball(new BallPosition(index), BallNumber.convert(inputValues[index])));
        }

        return new Balls(balls);
    }

    public int getSize() {
        return balls.size();
    }

    public List<Ball> get() {
        return balls;
    }

    public void addBall(final Ball ball) {
        if (isNotAvailableAddingBall(ball)) {
            return;
        }

        balls.add(ball);
    }

    private void verifyBalls(final List<Ball> balls) {
        if (balls.size() > BALLS_SIZE) {
            throw new BallsSizeOutOfIndexException();
        }
    }

    private boolean isNotAvailableAddingBall(final Ball ball) {
        return balls.contains(ball);
    }

    public boolean isContinuableAddingBall() {
        return balls.size() < BALLS_SIZE;
    }
}
