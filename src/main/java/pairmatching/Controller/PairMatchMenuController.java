package pairmatching.Controller;

import java.util.List;
import java.util.Set;
import pairmatching.Domain.Course;
import pairmatching.Domain.CourseLevelHistory;
import pairmatching.Domain.CourseLevelMissionHistory;
import pairmatching.Domain.CrewGroup;
import pairmatching.Domain.Level;
import pairmatching.Domain.Mission;
import pairmatching.Domain.Pair;
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
        makePair();

    }

    private void makePair() {
        List<String> input = inputView.inputCourseLevelMission();
        validateInput(input);
        if (courseLevelMissionHistory.hasMatchedPair(input.get(course), input.get(level), input.get(mission))) {
            //TODO: 이미 진행한 미션
        }
        Set<Pair> pairSet = crewGroup.makePairsByCourse(Course.findCourse(input.get(course)));
        courseLevelHistory.addHistory(input.get(course), input.get(level), pairSet);
        courseLevelMissionHistory.addHistory(input.get(course), input.get(level), input.get(mission), pairSet);
        outputView.showPair(pairSet);
    }

    private void validateInput(List<String> input) {
        Course.validateCourse(input.get(course));
        Level.validateLevel(input.get(level));
        Mission.validateMission(input.get(mission));
    }
}
