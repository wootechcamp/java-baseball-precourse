package learning.test;

import static org.assertj.core.api.Assertions.*;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("학습테스트 - Set")
public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("기본으로 주어진 Set의 Size가 3인가?")
    void 기본으로_주어진_Set의_Size가_3인가() {
        //given
        final int expectedSize = 3;

        //when, then
        assertThat(numbers).hasSize(expectedSize);
    }

    @ParameterizedTest(name = "[{index}] ParameterizedTest를 활용해 중복 코드를 제거 할수 있는가? number: {argumentsWithNames}")
    @ValueSource(ints = {1, 2, 3})
    void ParameterizedTest를_활용해_중복_코드를_제거_할수_있는가(int number) {
        //when, then
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest(name = "[{index}] 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는가? numbers: {argumentsWithNames}")
    @CsvSource({"1,2,3,4,5"})
    void _1과2그리고3_값은_contains_메소드_실행결과_true_4와5_값을_넣으면_false_가_반환되는가(int firstTrueNumber, int secondTrueNumber,
        int thirdTrueNumber, int firstFalseNumber, int secondFalseNumber) {
        //when, then
        assertThat(numbers).containsExactly(firstTrueNumber, secondTrueNumber, thirdTrueNumber);
        assertThat(numbers).doesNotContainSubsequence(firstFalseNumber, secondFalseNumber);
    }
}
