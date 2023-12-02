package pairmatching.Controller;

import java.util.List;
import pairmatching.View.InputView;
import pairmatching.View.OutputView;

public class PairMatchingController implements Controller{

    private final InputView inputView;
    private final OutputView outputView;
    public PairMatchingController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    @Override
    public void run() {
        outputView.showOptions();
        List<String> options = inputView.inputOptions();

    }
}
