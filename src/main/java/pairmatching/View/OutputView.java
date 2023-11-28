package pairmatching.View;

import static pairmatching.Message.PairMatchingPrompt.OPTION_MISSIONS;
import static pairmatching.Message.PairMatchingPrompt.OPTION_COURSE;
import static pairmatching.Message.PairMatchingPrompt.OPTION_MISSION;
import static pairmatching.Message.PairMatchingPrompt.OPTION_SHOP;

import java.util.List;
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
}
