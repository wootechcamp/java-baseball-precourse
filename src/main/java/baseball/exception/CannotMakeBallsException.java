package baseball.exception;

public class CannotMakeBallsException extends BaseballRuntimeException {
    private static final String message = "야구공 그룹을 만들 수 없습니다.";

    public CannotMakeBallsException() {
        super(message);
    }
}
