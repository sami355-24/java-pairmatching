package pairmatching.View;

import static pairmatching.Message.Prompt.COURSE_LEVEL_MISSION;
import static pairmatching.Message.Prompt.FRONT_MENU;
import static pairmatching.Message.Prompt.PAIR_MATCH_MENU;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import pairmatching.View.IO.Reader;

public class InputView {

    String pattern = "^[가-힣]+, 레벨[0-9]+, [가-힣]+$";
    Pattern regex = Pattern.compile(pattern);

    public String inputMenu() {
        System.out.println(FRONT_MENU);
        return Reader.getString();
    }

    public List<String> inputCourseLevelMission() {
        System.out.println(PAIR_MATCH_MENU);
        System.out.println(COURSE_LEVEL_MISSION);

        String input = Reader.getString();
        Matcher matcher = regex.matcher(input);
        if (matcher.matches())
            return List.of(input.split(", "));
        throw new IllegalArgumentException("입력 형식이 잘못되었습니다.");
    }
}
