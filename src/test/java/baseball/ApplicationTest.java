package baseball;

import nextstep.test.NSTest;
import nextstep.utils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class ApplicationTest extends NSTest {
    @BeforeEach
    void beforeEach() {
        super.setUp();
    }

    @Test
    void 스트라이크() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(7, 1, 3);
            running("789", "719", "713");
            verify("1스트라이크", "2스트라이크", "3스트라이크");
        }
    }

    @Test
    void 볼() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(7, 1, 3);
            running("987", "937", "137");
            verify("1볼", "2볼", "3볼");
        }
    }

    @Test
    void 낫싱() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(7, 1, 3);
            running("456");
            verify("낫싱");
        }
    }

    @Test
    void 게임_중_입력오류() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(7, 1, 3);
            running("가나1", "가12", "1234", "12", " ", "222");
            verify("[ERROR] 숫자 만 입력해 주세요.", "[ERROR] 3자리의 숫자를 입력해 주세요.", "[ERROR] 같은 숫자는 입력 할 수 없습니다.");
        }
    }

    @Test
    void 게임종료_후_재시작() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(7, 1, 3)
                .thenReturn(5, 8, 9);
            run("713", "1", "597", "589", "2");
            verify("3스트라이크", "게임 끝", "1스트라이크 1볼");
        }
    }

    @Test
    void 게임종료_후_재시작_입력오류() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(7, 1, 3)
                .thenReturn(5, 8, 9);
            run("713", "1", "597", "589", "ㅇㄹ", " ", "3", "2");
            verify("3스트라이크", "게임 끝", "1스트라이크 1볼", "[ERROR] 1이나 2의 값을 입력해주세요.");
        }
    }

    @AfterEach
    void tearDown() {
        outputStandard();
    }

    @Override
    public void runMain() {
        Application.main(new String[] {});
    }
}
