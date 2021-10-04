package baseball.domain;

import static org.assertj.core.api.Assertions.*;
import baseball.exception.CannotMakeBallsException;
import org.junit.jupiter.api.Test;

class BallsTest {

    @Test
    void 정해진_양만큼의_야구공그룹을_만들_수_있다() {
        assertThatNoException().isThrownBy(() -> {
            Ball[] balls = new Ball[Balls.BALLS_SIZE];

            for (int index = 0; index < Balls.BALLS_SIZE; index++) {
                balls[index] = new Ball(new BallPosition(index), new BallNumber(index + 1));
            }

            new Balls(balls);
        });
    }

    @Test
    void 정해진_야구공의_양_이상으로_야구공그룹을_만드려고_하면_예외가_발생한다() {
        assertThatExceptionOfType(CannotMakeBallsException.class).isThrownBy(() -> {
            final int allowPositionsSize = BallPosition.ALLOW_POSITIONS.size() - 1;
            final int overflowBallGroupsSize = Balls.BALLS_SIZE + 1;
            Ball[] balls = new Ball[overflowBallGroupsSize];

            for (int index = 0; index < overflowBallGroupsSize; index++) {
                final int allowPosition = Math.min(index, allowPositionsSize);
                balls[index] = new Ball(new BallPosition(allowPosition), new BallNumber(index + 1));
            }

            new Balls(balls);
        });
    }
}