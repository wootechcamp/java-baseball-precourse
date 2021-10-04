package baseball.component;

import baseball.domain.BallNumber;
import nextstep.utils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(BallNumber.MINIMUM_NUMBER, BallNumber.MAXIMUM_NUMBER);
    }
}
