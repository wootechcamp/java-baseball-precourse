package baseball.domain;

import baseball.exception.NotAllowPositionException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class BallPosition {
    public static final Set<Integer> ALLOW_POSITIONS = new HashSet<>(Arrays.asList(0, 1, 2));

    private final int position;

    public BallPosition(final int position) {
        verifyBallPosition(position);

        this.position = position;
    }

    public int get() {
        return position;
    }

    private void verifyBallPosition(final int position) {
        if (!ALLOW_POSITIONS.contains(position)) {
            throw new NotAllowPositionException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BallPosition)) {
            return false;
        }
        BallPosition that = (BallPosition)o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
