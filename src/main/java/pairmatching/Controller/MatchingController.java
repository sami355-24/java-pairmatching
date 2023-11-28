package pairmatching.Controller;

import static pairmatching.Controller.FrontController.guide;

import pairmatching.View.InputView;
import pairmatching.View.OutputView;

public class MatchingController implements Controller{

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    @Override
    public void run() {
        outputView.showDelimiter();
        outputView.showOptionsCourses(guide.getCourses());
        for (int i = 0; i < guide.getLevels().size(); i++) {
            String level = guide.getLevels().get(i);
            outputView.showOptionsMissionPerLevel(level, guide.getMissionsPerLevel().get(level).getMissions());
        }
        outputView.showDelimiter();
    }
}
