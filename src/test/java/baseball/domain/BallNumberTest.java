package baseball.domain;

import static org.assertj.core.api.Assertions.*;
import baseball.exception.BallNumberOutOfRangeException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallNumberTest {

    @ParameterizedTest(name = "[{index}] 야구공의 숫자는 정해진 범위로 만들 수 있다 | {argumentsWithNames}")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void 야구공의_숫자는_정해진_범위로_만들_수_있다(int number) {
        assertThatNoException().isThrownBy(() -> new BallNumber(number));
    }

    @ParameterizedTest(name = "[{index}] 정해진 범위를 벗어나는 숫자로 야구공숫자를 만드려고하면 예외가 발생한다 | {argumentsWithNames}")
    @ValueSource(ints = {BallNumber.MINIMUM_NUMBER - 1, BallNumber.MAXIMUM_NUMBER + 1})
    void 정해진_범위를_벗어나는_숫자로_야구공숫자를_만드려고하면_예외가_발생한다(int number) {
        assertThatExceptionOfType(BallNumberOutOfRangeException.class).isThrownBy(() -> new BallNumber(number));
    }
}