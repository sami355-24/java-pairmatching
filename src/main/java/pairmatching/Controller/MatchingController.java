package pairmatching.Controller;

import static pairmatching.Controller.FrontController.guide;

import java.util.Set;
import pairmatching.Domain.MatchingResult;
import pairmatching.Domain.MatchingResultGroup;
import pairmatching.View.InputView;
import pairmatching.View.OutputView;

public class MatchingController implements Controller {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final MatchingResultGroup matchingResultGroup = new MatchingResultGroup();

    @Override
    public void run() {
        showOptions();
        String options = inputOptions();
        showMatchingResult(options);
    }

    private void showOptions() {
        outputView.showDelimiter("\n");
        outputView.showOptionsCourses(guide.getCourses());
        for (int i = 0; i < guide.getLevels().size(); i++) {
            String level = guide.getLevels().get(i);
            outputView.showOptionsMissionPerLevel(level, guide.getMissionsPerLevel().get(level).getMissions());
        }
        outputView.showDelimiter("");
    }

    protected String inputOptions() {
        String options = inputView.inputCourseLevelMission();
        MatchingResult result = new MatchingResult(options);
        if (!matchingResultGroup.isExistMatchingResult(options)) {
            matchingResultGroup.addMatchingResult(options, result);
            return options;
        }
        retryMatch(options, result);
        return options;
    }

    private void retryMatch(String options, MatchingResult result) {
        String userInput = inputView.inputUserIntent();
        if (userInput.equals("네")) {
            matchingResultGroup.addMatchingResult(options, result);
        }
        throw new IllegalArgumentException();
    }

    private void showMatchingResult(String options) {
        MatchingResult matchingResult = matchingResultGroup.findMatchingResult(options);
        Set<Set<String>> result = matchingResult.getResult();
        outputView.showMatchingResult(result);
    }


}
