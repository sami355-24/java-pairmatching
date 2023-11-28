package pairmatching.Controller;

import static pairmatching.Controller.FrontController.guide;

import java.sql.PreparedStatement;
import pairmatching.Domain.MatchingResult;
import pairmatching.Domain.MatchingResultGroup;
import pairmatching.View.InputView;
import pairmatching.View.OutputView;

public class MatchingController implements Controller{

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final MatchingResultGroup matchingResultGroup = new MatchingResultGroup();

    @Override
    public void run() {
        showOptions();
        inputOptions();
    }

    private void showOptions() {
        outputView.showDelimiter();
        outputView.showOptionsCourses(guide.getCourses());
        for (int i = 0; i < guide.getLevels().size(); i++) {
            String level = guide.getLevels().get(i);
            outputView.showOptionsMissionPerLevel(level, guide.getMissionsPerLevel().get(level).getMissions());
        }
        outputView.showDelimiter();
    }

    private void inputOptions() {
        String options = inputView.inputCourseLevelMission();
        MatchingResult result = new MatchingResult(options);
        matchingResultGroup.addMatchingResult(options, result);
    }


}
