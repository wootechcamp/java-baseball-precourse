package baseball.domain;

import baseball.exception.BallNumberOutOfRangeException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

class BallTest {

    @ParameterizedTest(name = "[{index}] 1~9까지 수로 야구공을 만들 수 있다 | {argumentsWithNames}")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void _1에서_9까지_수로_야구공을_만들_수_있다(int number) {
        assertThatNoException()
                .as("1~9까지 수로 공을 만들 수 있는가?")
                .isThrownBy(() -> new Ball(new BallPosition(0), new BallNumber(number)));
    }

    @ParameterizedTest(name = "[{index}] 1~9까지 수가 아닌 것으로 야구공을 만들 수 없다 | {argumentsWithNames}")
    @ValueSource(ints = {0, -1, 10, 11})
    void _1에서_9까지_수가_아닌_것으로_야구공을_만들_수_없다(int number) {
        assertThatExceptionOfType(BallNumberOutOfRangeException.class).isThrownBy(() -> new Ball(new BallPosition(0), new BallNumber(number)));
    }
}