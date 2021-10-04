package baseball.domain;

import static org.assertj.core.api.Assertions.*;
import baseball.exception.IllegalInputValueException;
import org.junit.jupiter.api.Test;

class PitcherTest {

    @Test
    void 게임_플레이어는_컴퓨터가_생각하고_있는_3개의_숫자를_입력한다() {
        final Pitcher pitcher = new Pitcher();
        final Balls playerBalls = pitcher.throwBalls("452");

        assertThat(playerBalls.get())
            .containsExactly(
                new Ball(new BallPosition(0), new BallNumber(4)),
                new Ball(new BallPosition(1), new BallNumber(5)),
                new Ball(new BallPosition(2), new BallNumber(2))
            );
    }

    @Test
    void 숫자가_아닌_값을_입력하면_예외가_발생한다() {
        assertThatExceptionOfType(IllegalInputValueException.class).isThrownBy(() -> {
            final Pitcher pitcher = new Pitcher();
            pitcher.throwBalls("52다");
        });
    }

    @Test
    void _3자리수가_아닌_숫자를_입력한다() {
        assertThatExceptionOfType(IllegalInputValueException.class).isThrownBy(() -> {
            final Pitcher pitcher = new Pitcher();
            pitcher.throwBalls("5232");
        });
    }
}