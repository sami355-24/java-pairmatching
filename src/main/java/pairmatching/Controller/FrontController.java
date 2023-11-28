package pairmatching.Controller;

import java.util.HashMap;
import java.util.Map;
import pairmatching.Domain.Guide.Guide;
import pairmatching.View.InputView;

public class FrontController implements Controller{

    private final Map<Integer, Controller> controllers;
    private static final InputView inputView = new InputView();
    static Guide guide = new Guide();

    public FrontController() {
        controllers = new HashMap<>();
        controllers.put(1, new MatchingController());
    }

    @Override
    public void run() {
        int controllerNumber = inputView.inputFunction();
        controllers.get(controllerNumber).run();
    }
}
