package pairmatching.Controller;

import static pairmatching.Message.Excepton.ExceptionPrompt.NOT_FOUND;

import java.util.List;
import java.util.Set;
import pairmatching.Domain.Course;
import pairmatching.Domain.CourseLevelMissionHistory;
import pairmatching.Domain.Level;
import pairmatching.Domain.Mission;
import pairmatching.Domain.Pair;
import pairmatching.Exception.InvalidInputException;
import pairmatching.Exception.NoHistoryException;
import pairmatching.View.InputView;
import pairmatching.View.OutputView;

public class PairSearchController implements Controller{

    private final int course = 0;
    private final int level = 1;
    private final int mission = 2;

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final CourseLevelMissionHistory courseLevelMissionHistory = CourseLevelMissionHistory.getInstance();


    @Override
    public void run() {
        outputView.showCourseLevelMission();
        List<String> input = inputView.inputCourseLevelMission();
        validateInput(input);
        Set<Pair> history = courseLevelMissionHistory.getHistory(
                input.get(course),
                input.get(level),
                input.get(mission));
        isEmptyHistory(history);
        outputView.showPair(history);
        outputView.newLine();
    }

    private void validateInput(List<String> input) {
        Course.validateCourse(input.get(course));
        Level.validateLevel(input.get(level));
        Mission.validateMission(input.get(mission));
        Level.validateMissionInLevel(input.get(level), input.get(mission));
    }

    private void isEmptyHistory(Set<Pair> history) {
        if (history.isEmpty()) {
            throw new NoHistoryException(NOT_FOUND.getPrompt(), new IllegalArgumentException());
        }
    }
}