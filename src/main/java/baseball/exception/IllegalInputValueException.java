package baseball.exception;

public class IllegalInputValueException extends BaseballRuntimeException {
    public IllegalInputValueException(final String message) {
        super(message);
    }

    public IllegalInputValueException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public IllegalInputValueException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
