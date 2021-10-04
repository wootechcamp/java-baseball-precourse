package baseball.exception;

import baseball.domain.Balls;
import java.text.MessageFormat;

public class BallsSizeOutOfIndexException extends BaseballRuntimeException {
    private static final String message = MessageFormat.format("야구공 {0}개 이상의 야구공 그룹을 만들 수 없습니다.", Balls.BALLS_SIZE);

    public BallsSizeOutOfIndexException() {
        super(message);
    }
}
