package pairmatching.View;

import static pairmatching.Message.Excepton.ExceptionPrompt.INVALID_INPUT;
import static pairmatching.Message.Prompt.ASK_RETRY;
import static pairmatching.Message.Prompt.COURSE_LEVEL_MISSION;
import static pairmatching.Message.Prompt.FRONT_MENU;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import pairmatching.Exception.InvalidInputException;
import pairmatching.View.IO.Reader;

public class InputView {

    String pattern = "^[가-힣]+, 레벨[0-9]+, [가-힣]+$";
    Pattern regex = Pattern.compile(pattern);

    public String inputMenu() {
        System.out.println(FRONT_MENU);
        return Reader.getString();
    }

    public List<String> inputCourseLevelMission() {
        System.out.println(COURSE_LEVEL_MISSION);
        String input = Reader.getString();
        Matcher matcher = regex.matcher(input);
        if (matcher.matches())
            return List.of(input.split(", "));
        throw new InvalidInputException(INVALID_INPUT.getPrompt(), new IllegalArgumentException());
    }

    public String askRetry() {
        System.out.println(ASK_RETRY);
        return Reader.getString();
    }
}
