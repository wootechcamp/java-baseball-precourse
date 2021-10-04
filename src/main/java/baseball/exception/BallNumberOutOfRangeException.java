package baseball.exception;

import baseball.domain.BallNumber;
import java.text.MessageFormat;

public class BallNumberOutOfRangeException extends BaseballRuntimeException {
    private static final String message = MessageFormat.format("야구공 번호는 {0}~{1} 사이의 숫자만 허용됩니다.",
        BallNumber.MINIMUM_NUMBER, BallNumber.MAXIMUM_NUMBER);

    public BallNumberOutOfRangeException() {
        super(message);
    }
}
