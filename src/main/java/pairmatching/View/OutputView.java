package pairmatching.View;

import static pairmatching.Message.Prompt.COURSE_LEVEL_MISSION;
import static pairmatching.Message.Prompt.PAIR_MATCH_MENU;
import static pairmatching.Message.Prompt.PAIR_MATCH_RESULT;

import java.util.Set;
import java.util.stream.Collectors;
import pairmatching.Domain.Pair;

public class OutputView {

    public void showCourseLevelMission(){
        System.out.println(PAIR_MATCH_MENU);
    }

    public void showPair(Set<Pair> pairs){
        System.out.println(PAIR_MATCH_RESULT);
        for (Pair pair : pairs) {
            System.out.println(String.join(" : ", pair.getMembers()));
        }
    }
}
