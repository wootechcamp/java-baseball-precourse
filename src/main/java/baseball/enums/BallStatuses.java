package baseball.enums;

import static baseball.enums.BallStatus.*;
import baseball.domain.Balls;
import baseball.exception.IllegalBallStatusesStateException;
import java.util.Arrays;
import java.util.List;

public class BallStatuses {
    public static final List<BallStatus> COMPLETE_BALL_STATUSES = Arrays.asList(STRIKE, STRIKE, STRIKE);
    public static final List<BallStatus> NOTHING_BALL_STATUES = Arrays.asList(NOTHING, NOTHING, NOTHING);

    private final List<BallStatus> ballStatuses;

    public BallStatuses(final List<BallStatus> ballStatuses) {
        verifyBallStatuses(ballStatuses);

        this.ballStatuses = ballStatuses;
    }

    public List<BallStatus> get() {
        return ballStatuses;
    }

    public boolean isCompleted() {
        return COMPLETE_BALL_STATUSES.containsAll(ballStatuses);
    }

    public boolean isAllNothing() {
        return NOTHING_BALL_STATUES.containsAll(ballStatuses);
    }

    private void verifyBallStatuses(final List<BallStatus> ballStatuses) {
        if (ballStatuses.size() > Balls.BALLS_SIZE) {
            throw new IllegalBallStatusesStateException();
        }
    }
}
