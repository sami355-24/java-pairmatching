package pairmatching.Controller;

import static pairmatching.Message.Excepton.ExceptionPrompt.INVALID_INPUT;
import static pairmatching.Message.Excepton.ExceptionPrompt.RETRY;

import java.util.List;
import java.util.Set;
import pairmatching.Domain.Course;
import pairmatching.Domain.CourseLevelHistory;
import pairmatching.Domain.CourseLevelMissionHistory;
import pairmatching.Domain.CrewGroup;
import pairmatching.Domain.Level;
import pairmatching.Domain.Mission;
import pairmatching.Domain.Pair;
import pairmatching.Exception.InvalidInputException;
import pairmatching.Exception.RetryException;
import pairmatching.View.InputView;
import pairmatching.View.OutputView;

public class PairMatchMenuController implements Controller {

    private final int course = 0;
    private final int level = 1;
    private final int mission = 2;

    private final CourseLevelHistory courseLevelHistory = CourseLevelHistory.getInstance();
    private final CourseLevelMissionHistory courseLevelMissionHistory = CourseLevelMissionHistory.getInstance();
    private final CrewGroup crewGroup = CrewGroup.getInstance();

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    @Override
    public void run() {
        outputView.showCourseLevelMission();
        matchPair();

    }

    protected void matchPair() {
        List<String> input = inputView.inputCourseLevelMission();
        validateInput(input);
        hasMatchedHistoryInCourseLevelMission(input);
        Set<Pair> pairSet = crewGroup.makePairsByCourse(Course.findCourse(input.get(course)));

        if (courseLevelHistory.hasMatchedPair(input.get(course), input.get(level), pairSet)) {
            //TODO: 동일 레벨에 매칭 기록이 있는지 확인
        }

        courseLevelHistory.addHistory(input.get(course), input.get(level), pairSet);
        courseLevelMissionHistory.addHistory(input.get(course), input.get(level), input.get(mission), pairSet);
        outputView.showPair(pairSet);
    }

    private void hasMatchedHistoryInCourseLevelMission(List<String> input) {
        if (courseLevelMissionHistory.hasMatchedPair(input.get(course), input.get(level), input.get(mission))) {
            String answer = inputView.askRetry();
            if (answer.equals("네")) {
                return;
            }
            if (answer.equals("아니오")) {
                throw new RetryException(RETRY.getPrompt(), new IllegalArgumentException());
            }
            throw new InvalidInputException(INVALID_INPUT.getPrompt(), new IllegalArgumentException());
        }
    }


    private void validateInput(List<String> input) {
        Course.validateCourse(input.get(course));
        Level.validateLevel(input.get(level));
        Mission.validateMission(input.get(mission));
        Level.validateMissionInLevel(input.get(level), input.get(mission));
    }
}
