package baseball.enums;

import java.util.Arrays;
import java.util.EnumSet;

public enum GameStatus {
    START("-1", "숫자를 입력해주세요 : "),
    COMPLETE("0", "3개의 숫자를 모두 맞히셨습니다! 게임 끝\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    RESTART("1", "숫자를 입력해주세요 : "),
    TERMINATE("2", "");

    private final String status;
    private final String message;

    GameStatus(final String status, final String message) {
        this.status = status;
        this.message = message;
    }

    public boolean isContinuable() {
        return EnumSet.of(START, RESTART).contains(this);
    }

    public static boolean isChooseStatus(final String status) {
        return Arrays.asList(RESTART.getStatus(), TERMINATE.getStatus()).contains(status);
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public boolean match(final GameStatus gameStatus) {
        return this.equals(gameStatus);
    }

    public boolean match(final String gameStatus) {
        return status.equals(gameStatus);
    }
}
