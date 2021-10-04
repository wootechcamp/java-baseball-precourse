package baseball.exception;

public class BaseballRuntimeException extends RuntimeException {
    private static final String defaultMessage = "숫자야구게임 실행 중 오류가 발생했습니다.";
    protected static final String ERROR_MESSAGE_FORMAT = "[ERROR] {0}";

    public BaseballRuntimeException() {
        super(String.format(ERROR_MESSAGE_FORMAT, defaultMessage));
    }

    public BaseballRuntimeException(final String message) {
        super(String.format(ERROR_MESSAGE_FORMAT, message));
    }

    public BaseballRuntimeException(final String message, final Throwable cause) {
        super(String.format(ERROR_MESSAGE_FORMAT, message), cause);
    }

    public BaseballRuntimeException(final Throwable cause) {
        super(String.format(ERROR_MESSAGE_FORMAT, defaultMessage), cause);
    }

    public BaseballRuntimeException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(String.format(ERROR_MESSAGE_FORMAT, message), cause, enableSuppression, writableStackTrace);
    }
}
