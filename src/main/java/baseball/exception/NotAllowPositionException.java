package baseball.exception;

public class NotAllowPositionException extends BaseballRuntimeException {
    private static final String message = "허용하지 않는 야구공 위치입니다.";

    public NotAllowPositionException() {
        super(message);
    }
}
