package baseball.domain;

import baseball.exception.NotAllowPositionException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

class BallPositionTest {

    @Test
    void 야구공의_위치설정은_정해놓은_수_만큼만_가능하다() {
        assertThatNoException().isThrownBy(() -> {
            for (Integer allowPosition : BallPosition.ALLOW_POSITIONS) {
                new BallPosition(allowPosition);
            }
        });
    }

    @Test
    void 야구공의_위치설정은_정해놓은_수를_벗어나면_예외가_발생한다() {
        assertThatExceptionOfType(NotAllowPositionException.class).isThrownBy(() -> {
            for (Integer allowPosition : BallPosition.ALLOW_POSITIONS) {
                new BallPosition(allowPosition + 1);
            }
        });
    }
}