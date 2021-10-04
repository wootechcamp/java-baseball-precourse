package baseball;

import baseball.component.RandomNumberGenerator;
import baseball.domain.Computer;
import baseball.domain.Pitcher;
import baseball.view.GameController;
import baseball.view.GameViewer;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        final GameController controller = new GameController(
            new Computer(new RandomNumberGenerator()),
            new Pitcher(),
            new GameViewer()
        );

        controller.start();
    }
}
