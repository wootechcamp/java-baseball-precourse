package baseball.enums;

import baseball.domain.Balls;
import baseball.exception.IllegalBallStatusesStateException;
import java.util.List;

public class BallStatuses {
    private final List<BallStatus> ballStatuses;

    public BallStatuses(final List<BallStatus> ballStatuses) {
        verifyBallStatuses(ballStatuses);

        this.ballStatuses = ballStatuses;
    }

    public List<BallStatus> get() {
        return ballStatuses;
    }

    public boolean isCompleted() {
        return BallStatus.COMPLETE_BALL_STATUSES.containsAll(ballStatuses);
    }

    private void verifyBallStatuses(final List<BallStatus> ballStatuses) {
        if (ballStatuses.size() > Balls.BALLS_SIZE) {
            throw new IllegalBallStatusesStateException();
        }
    }
}
