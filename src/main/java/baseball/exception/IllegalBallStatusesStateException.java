package baseball.exception;

import baseball.domain.Balls;
import java.text.MessageFormat;

public class IllegalBallStatusesStateException extends BaseballRuntimeException {
    private static final String message = MessageFormat.format("{0}개 보다 많은 피칭 결과가 생성될 수 없습니다.", Balls.BALLS_SIZE);

    public IllegalBallStatusesStateException() {
        super(message);
    }
}
