package pairmatching.Controller;

import java.util.HashMap;
import java.util.Map;
import pairmatching.View.InputView;
import pairmatching.View.OutputView;

public class FrontController implements Controller {

    private static Map<String, Controller> controllers = new HashMap<>();
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public FrontController() {
        controllers.put("1", new PairMatchMenuController());
    }

    @Override
    public void run() {
        while (true) {
            String menu = inputView.inputMenu();
            if (menu.equals("q")) {
                break;
            }
            controllers.get(menu).run();
        }
    }
}
