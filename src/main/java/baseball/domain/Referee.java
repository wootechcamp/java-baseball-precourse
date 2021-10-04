package baseball.domain;

import baseball.enums.BallStatus;
import baseball.enums.BallStatuses;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Referee {

    public BallStatuses judge(final Balls computerBalls, final Balls pitcherBalls) {
        final List<BallStatus> ballStatuses = new ArrayList<>();

        for (Ball pitcherBall : pitcherBalls.getBalls()) {
            ballStatuses.add(judge(computerBalls, pitcherBall));
        }

        return new BallStatuses(ballStatuses);
    }

    public BallStatus judge(final Balls computerBalls, final Ball pitcherBall) {
        if (isStrike(computerBalls, pitcherBall)) {
            return BallStatus.STRIKE;
        }

        if (isBall(computerBalls, pitcherBall)) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    private boolean isStrike(final Balls computerBalls, final Ball pitcherBall) {
        final BallPosition pitcherBallPosition = pitcherBall.getBallPosition();

        final Ball computerBall = computerBalls.getBalls().get(pitcherBallPosition.get());
        final BallPosition computerBallPosition = computerBall.getBallPosition();
        final BallNumber computerBallNumber = computerBall.getBallNumber();

        return Objects.equals(computerBallPosition, pitcherBallPosition) && Objects.equals(computerBallNumber,
            pitcherBall.getBallNumber());
    }

    private boolean isBall(final Balls computerBalls, final Ball pitcherBall) {
        return computerBalls.getBalls().contains(pitcherBall);
    }
}
