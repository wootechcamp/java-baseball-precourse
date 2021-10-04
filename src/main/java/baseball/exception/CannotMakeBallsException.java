package baseball.exception;

public class CannotMakeBallsException extends BaseballRuntimeException {
    private static final String message = "야구공 그룹을 만들 수 없습니다.";

    public CannotMakeBallsException() {
        super(message);
    }

    public CannotMakeBallsException(final Throwable cause) {
        super(message, cause);
    }

    public CannotMakeBallsException(final Throwable cause, final boolean enableSuppression,
        final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
