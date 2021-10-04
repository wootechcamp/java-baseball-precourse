package baseball.exception;

import baseball.domain.Balls;
import java.text.MessageFormat;

public class IllegalBallStatusesStateException extends BaseballRuntimeException {
    private static final String message = MessageFormat.format("{0}개 보다 많은 피칭 결과가 생성될 수 없습니다.", Balls.BALLS_SIZE);

    public IllegalBallStatusesStateException() {
        super(message);
    }

    public IllegalBallStatusesStateException(Throwable cause) {
        super(message, cause);
    }

    public IllegalBallStatusesStateException(Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
