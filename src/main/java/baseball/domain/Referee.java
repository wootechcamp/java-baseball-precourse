package baseball.domain;

import baseball.enums.BallStatus;
import java.util.Objects;

public class Referee {
    public BallStatus judge(final Balls computerBalls, final Ball playerBall) {
        if (isStrike(computerBalls, playerBall)) {
            return BallStatus.STRIKE;
        }

        if (isBall(computerBalls, playerBall)) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    private boolean isStrike(final Balls computerBalls, final Ball playerBall) {
        final BallPosition playerBallPosition = playerBall.getBallPosition();

        final Ball computerBall = computerBalls.getBalls().get(playerBallPosition.getPosition());
        final BallPosition computerBallPosition = computerBall.getBallPosition();
        final BallNumber computerBallNumber = computerBall.getBallNumber();

        return Objects.equals(computerBallPosition, playerBallPosition) && Objects.equals(computerBallNumber,
            playerBall.getBallNumber());
    }

    private boolean isBall(final Balls computerBalls, final Ball playerBall) {
        return computerBalls.getBalls().contains(playerBall);
    }
}
