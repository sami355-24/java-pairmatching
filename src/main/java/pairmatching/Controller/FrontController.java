package pairmatching.Controller;

import java.util.Map;
import pairmatching.View.InputView;

public class FrontController implements Controller{

    private Map<String, Controller> controllers;
    private InputView inputView;
    public FrontController() {
        inputView = new InputView();
    }

    @Override
    public void run() {
        String menu = inputView.inputMainMenu();
    }
}
