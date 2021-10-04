package baseball;

import baseball.component.RandomNumberGenerator;
import baseball.controller.NumberBaseballGameController;
import baseball.controller.NumberBaseballGameViewer;
import baseball.domain.Computer;
import baseball.domain.Pitcher;
import baseball.domain.Referee;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        final NumberBaseballGameController controller = new NumberBaseballGameController(
            new Referee(),
            new Computer(new RandomNumberGenerator()),
            new Pitcher(),
            new NumberBaseballGameViewer()
        );

        controller.start();
    }
}
