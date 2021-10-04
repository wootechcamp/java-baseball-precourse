package baseball;

import baseball.component.RandomNumberGenerator;
import baseball.controller.NumberBaseballGameController;
import baseball.controller.NumberBaseballGameViewer;
import baseball.domain.Computer;
import baseball.domain.Pitcher;
import baseball.domain.Referee;

public class Application {
    public static void main(String[] args) {
        final NumberBaseballGameController controller = new NumberBaseballGameController(
            new Referee(),
            new Computer(new RandomNumberGenerator()),
            new Pitcher(),
            new NumberBaseballGameViewer()
        );

        controller.start();
    }
}
