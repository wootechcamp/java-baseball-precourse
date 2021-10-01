package learning.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("학습테스트 - String Class")
public class StringTest {

    private final static String DELIMITER = ",";

    @Test
    @DisplayName("\"1,2\"을 `,`로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
    void _1과2를_콤마로_split_했을_때_1과_2로_분리되는가() {
        //given
        final String csvValue = "1,2";

        //when
        final String[] dividedValues = csvValue.split(DELIMITER);

        //then
        assertThat(dividedValues)
                .as("`,`로 split 했을 때 1과 2로 잘 분리 되는가?")
                .contains("1", "2");
    }

    @Test
    @DisplayName("\"1\"을 `,`로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스틑 구현한다.")
    void _1을_콤마로_split_했을_때_1만_포함하는_배열이_반환되는가() {
        //given
        final String csvValue = "1";

        //when
        final String[] dividedValues = csvValue.split(DELIMITER);

        //then
        assertThat(dividedValues)
                .as("`,`로 split 했을 때 1만 포함하는가?")
                .containsExactly("1");
    }
}
