package pairmatching.View;

import static pairmatching.Message.PairMatchingPrompt.COURSE_MENU;
import static pairmatching.Message.PairMatchingPrompt.MISSION_INFO;
import static pairmatching.Message.PairMatchingPrompt.MISSION_MENU;
import static pairmatching.Message.PairMatchingPrompt.SHOP;

import java.util.Arrays;
import java.util.stream.Collectors;
import pairmatching.Domain.Course;
import pairmatching.Domain.Level;

public class OutputView {

    public void showOptions() {
        System.out.println("\n" + SHOP);
        System.out.printf((COURSE_MENU) + "%n", String.join(" | ", Course.findAllName()));
        System.out.println(MISSION_MENU);
        Arrays.stream(Level.values())
                .forEach(level -> System.out.printf((MISSION_INFO) + "%n",
                        level.getName(),
                        String.join(" | ", level.getMissions())));
        System.out.println(SHOP);
    }

}
