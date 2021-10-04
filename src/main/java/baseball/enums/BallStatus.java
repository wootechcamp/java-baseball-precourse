package baseball.enums;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public enum BallStatus {
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱");

    public static final List<BallStatus> COMPLETE_BALL_STATUSES = Arrays.asList(STRIKE, STRIKE, STRIKE);
    public static final List<BallStatus> NOTHING_BALL_STATUES = Arrays.asList(NOTHING, NOTHING, NOTHING);

    private final String name;

    BallStatus(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean match(final BallStatus ballStatus) {
        return Objects.equals(this, ballStatus);
    }
}
