package baseball.component;

import baseball.domain.BallNumber;
import nextstep.utils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(BallNumber.MINIMUM_BALL, BallNumber.MAXIMUM_BALL);
    }
}
