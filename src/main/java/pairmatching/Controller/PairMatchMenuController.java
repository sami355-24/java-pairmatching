package pairmatching.Controller;

import java.util.List;
import pairmatching.Domain.Course;
import pairmatching.Domain.Level;
import pairmatching.Domain.Mission;
import pairmatching.View.InputView;

public class PairMatchMenuController implements Controller{

    private final int course = 0;
    private final int level = 1;
    private final int mission = 2;

    InputView inputView = new InputView();
    @Override
    public void run() {
        List<String> input = inputView.inputCourseLevelMission();
        Course.validateCourse(input.get(course));
        Level.validateLevel(input.get(level));
        Mission.validateMission(input.get(mission));
    }
}
