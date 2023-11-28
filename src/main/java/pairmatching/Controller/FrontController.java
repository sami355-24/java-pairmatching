package pairmatching.Controller;

import pairmatching.View.InputView;

public class FrontController implements Controller{

    private static final InputView inputView = new InputView();

    public FrontController() {
    }

    @Override
    public void run() {
        int i = inputView.inputFunction();
    }
}
