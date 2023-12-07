package pairmatching.Controller;

import pairmatching.Domain.CourseLevelHistory;
import pairmatching.Domain.CourseLevelMissionHistory;
import pairmatching.View.OutputView;

public class PairDeleteController implements Controller {

    private final OutputView outputView = new OutputView();
    private final CourseLevelHistory courseLevelHistory = CourseLevelHistory.getInstance();
    private final CourseLevelMissionHistory courseLevelMissionHistory = CourseLevelMissionHistory.getInstance();

    @Override
    public void run() {
        courseLevelHistory.clearHistory();
        courseLevelMissionHistory.clearHistory();
        outputView.initialize();
        outputView.newLine();
    }
}
