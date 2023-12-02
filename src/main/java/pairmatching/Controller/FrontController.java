package pairmatching.Controller;

import java.util.HashMap;
import java.util.Map;
import pairmatching.View.InputView;

public class FrontController implements Controller{

    private Map<String, Controller> controllers;
    private InputView inputView;
    public FrontController() {
        inputView = new InputView();
        controllers = new HashMap<>();
        controllers.put("1", new PairMatchingController());
    }

    @Override
    public void run() {
        String menu = inputView.inputMainMenu();
        controllers.get(menu).run();
    }
}
