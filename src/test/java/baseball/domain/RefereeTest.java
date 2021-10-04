package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {

    @Test
    void _3자리_숫자중에_같은_수가_같은_자리에_있으면_스트라이크이다() {
        final Ball firstBall = new Ball(new BallPosition(0), new BallNumber(1));
        final Ball secondBall = new Ball(new BallPosition(1), new BallNumber(4));
        final Ball thirdBall = new Ball(new BallPosition(2), new BallNumber(6));
        final Balls computerBalls = new Balls(firstBall, secondBall, thirdBall);

        final Ball playerBall = new Ball(new BallPosition(0), new BallNumber(1));

        final Referee referee = new Referee();
        BallStatus ballStatus = referee.judge(computerBalls, playerBall);

        assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void _3자리_숫자중에_다른_자리에_있으면_볼이다() {
        final Ball firstBall = new Ball(new BallPosition(0), new BallNumber(1));
        final Ball secondBall = new Ball(new BallPosition(1), new BallNumber(4));
        final Ball thirdBall = new Ball(new BallPosition(2), new BallNumber(6));
        final Balls computerBalls = new Balls(firstBall, secondBall, thirdBall);

        final Ball playerBall = new Ball(new BallPosition(0), new BallNumber(4));

        final Referee referee = new Referee();
        BallStatus ballStatus = referee.judge(computerBalls, playerBall);

        assertThat(ballStatus).isEqualTo(BallStatus.BALL);
    }

    @Test
    void _3자리_숫자중에_같은_수가_전혀_없으면_포볼_또는_낫싱이다() {
        final Ball firstBall = new Ball(new BallPosition(0), new BallNumber(1));
        final Ball secondBall = new Ball(new BallPosition(1), new BallNumber(4));
        final Ball thirdBall = new Ball(new BallPosition(2), new BallNumber(6));
        final Balls computerBalls = new Balls(firstBall, secondBall, thirdBall);

        final Ball playerBall = new Ball(new BallPosition(0), new BallNumber(7));

        final Referee referee = new Referee();
        BallStatus ballStatus = referee.judge(computerBalls, playerBall);

        assertThat(ballStatus).isEqualTo(BallStatus.NOTHING);
    }
}