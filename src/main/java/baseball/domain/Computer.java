package baseball.domain;

import baseball.component.NumberGenerator;

public class Computer {
    private final NumberGenerator numberGenerator;

    public Computer(final NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Balls prepareBalls() {
        final Balls balls = new Balls(new Ball(new BallPosition(0), new BallNumber(numberGenerator.generate())));

        while (balls.isContinuableAddingBall()) {
            balls.addBall(new Ball(new BallPosition(balls.getSize()), new BallNumber(numberGenerator.generate())));
        }

        return balls;
    }
}
