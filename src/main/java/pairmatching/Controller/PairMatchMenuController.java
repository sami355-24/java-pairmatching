package pairmatching.Controller;

import pairmatching.View.InputView;
import pairmatching.View.OutputView;

public class PairMatchMenuController implements Controller{

    InputView inputView = new InputView();
    @Override
    public void run() {
        String input = inputView.inputCourseLevelMission();
    }
}
