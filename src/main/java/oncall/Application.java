package oncall;

import oncall.controller.InputHandler;
import oncall.controller.WorkController;
import oncall.view.InputView;
import oncall.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        InputHandler inputHandler = new InputHandler(inputView);
        OutputView outputView = new OutputView();

        WorkController controller = new WorkController(inputHandler, outputView);
        controller.run();
    }
}
