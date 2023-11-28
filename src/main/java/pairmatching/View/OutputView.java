package pairmatching.View;

import static pairmatching.Message.PairMatchingPrompt.OPTION_MISSIONS;
import static pairmatching.Message.PairMatchingPrompt.OPTION_COURSE;
import static pairmatching.Message.PairMatchingPrompt.OPTION_MISSION;
import static pairmatching.Message.PairMatchingPrompt.OPTION_SHOP;
import static pairmatching.Message.PairMatchingPrompt.PAIR_MATCHING_RESULT;

import java.util.List;
import java.util.Set;
import pairmatching.View.IO.Printer;

public class OutputView {

    public void showOptionsCourses(List<String> courses) {
        Printer.printMessage(String.format(OPTION_COURSE, String.join(" | ", courses)));
        Printer.printMessage(OPTION_MISSION);
    }

    public void showDelimiter(String prefix) {
        Printer.printMessage(prefix + OPTION_SHOP);
    }

    public void showOptionsMissionPerLevel(String level, List<String> missions) {
        Printer.printMessage(String.format(OPTION_MISSIONS, level, String.join(" | ", missions)));
    }

    public void showMatchingResult(Set<Set<String>> options) {
        Printer.printMessage(PAIR_MATCHING_RESULT);
        for (Set<String> option : options) {
            Printer.printMessage(String.join(" : ", option));
        }
        Printer.printMessage("");
    }
}
