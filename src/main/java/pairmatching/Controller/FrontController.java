package pairmatching.Controller;

import java.util.HashMap;
import java.util.Map;
import pairmatching.Controller.DecoratorController.PairMatchMenuControllerDeco;
import pairmatching.Controller.DecoratorController.PairSearchControllerDeco;
import pairmatching.View.InputView;
import pairmatching.View.OutputView;

public class FrontController implements Controller {

    private static Map<String, Controller> controllers = new HashMap<>();
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public FrontController() {
        controllers.put("1", new PairMatchMenuControllerDeco());
        controllers.put("2", new PairSearchControllerDeco());
    }

    @Override
    public void run() {
        while (true) {
            String menu = inputView.inputMenu();
            if (menu.equals("q")) {
                break;
            }
            if (!controllers.containsKey(menu)) {
                outputView.showInvalidMenu();
                continue;
            }
            controllers.get(menu).run();
        }
    }
}
