package pairmatching.View;

import static pairmatching.Message.PairMatchingPrompt.*;
import static pairmatching.Message.PairMatchingPrompt.SELECT_FUNCTION;

import pairmatching.Message.PairMatchingPrompt;
import pairmatching.View.IO.Printer;
import pairmatching.View.IO.Reader;

public class InputView {

    public int inputFunction() {
        Printer.printMessage(SELECT_FUNCTION);
        return Reader.getInt();
    }

    public String inputCourseLevelMission() {
        Printer.printMessage(INPUT_COURSE_LEVEL_MISSION);
        Printer.printMessage(INPUT_COURSE_LEVEL_MISSION_EXAMPLE);
        return Reader.getString();
    }

}
