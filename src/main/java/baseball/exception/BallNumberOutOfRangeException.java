package baseball.exception;

import baseball.domain.BallNumber;

import java.text.MessageFormat;

public class BallNumberOutOfRangeException extends BaseballRuntimeException {
    private static final String message = MessageFormat.format("야구공 번호는 {0}~{1} 사이의 숫자만 허용됩니다.", BallNumber.MINIMUM_BALL, BallNumber.MAXIMUM_BALL);

    public BallNumberOutOfRangeException() {
        super(message);
    }

    public BallNumberOutOfRangeException(final Throwable cause) {
        super(message, cause);
    }

    public BallNumberOutOfRangeException(final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
