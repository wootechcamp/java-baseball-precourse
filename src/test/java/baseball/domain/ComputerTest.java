package baseball.domain;

import static org.assertj.core.api.Assertions.*;
import baseball.component.RandomNumberGenerator;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    void 컴퓨터는_1에서_9까지_서로_다른_임의의_수_3개를_선택한다() {
        assertThatNoException()
            .as("1~9까지 수 3개를 만드는가?")
            .isThrownBy(() -> {
                //given
                final Computer computer = new Computer(new RandomNumberGenerator());

                //when
                Balls balls = computer.prepareBalls();

                //then
                assertThat(balls)
                    .as("임의의수 3개를 반환하는가?")
                    .extracting(ballGroups -> ballGroups.getBalls().size())
                    .isEqualTo(Balls.BALLS_SIZE);

            });
    }
}
