package pairmatching.View;

import static pairmatching.Message.PairMatchingPrompt.LEVEL_MISSIONS;
import static pairmatching.Message.PairMatchingPrompt.MATCHING_COURSE;
import static pairmatching.Message.PairMatchingPrompt.MATCHING_MISSION;
import static pairmatching.Message.PairMatchingPrompt.MATCHING_SHOP;

import java.util.List;
import pairmatching.View.IO.Printer;

public class OutputView {

    public void showOptionsCourses(List<String> courses) {
        Printer.printMessage(String.format(MATCHING_COURSE, String.join(" | ", courses)));
        Printer.printMessage(MATCHING_MISSION);
    }

    public void showDelimiter() {
        Printer.printMessage(MATCHING_SHOP);
    }

    public void showOptionsMissionPerLevel(String level, List<String> missions) {
        Printer.printMessage(String.format(LEVEL_MISSIONS, level, String.join(" | ", missions)));
    }
}
