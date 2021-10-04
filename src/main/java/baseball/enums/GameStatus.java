package baseball.enums;

import java.util.Arrays;
import java.util.EnumSet;

public enum GameStatus {
    START("-1", "숫자를 입력해주세요 : "),
    COMPLETE("0", "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    RESTART("1", "숫자를 입력해주세요 : "),
    TERMINATE("2", "게임 끝");

    private final String status;
    private final String message;

    GameStatus(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public static boolean isContinuable(GameStatus status) {
        return EnumSet.of(START, RESTART).contains(status);
    }

    public static boolean isChooseStatus(String status) {
        return Arrays.asList(RESTART.getStatus(), TERMINATE.getStatus()).contains(status);
    }
}
