package pairmatching.View;

import static pairmatching.Message.PairMatchingPrompt.CHOOSE_OPTION;
import static pairmatching.Message.PairMatchingPrompt.CHOOSE_OPTION_EXAMPLE;
import static pairmatching.Message.PairMatchingPrompt.MAIN_MENU;

import java.util.List;
import pairmatching.View.IO.Reader;

public class InputView {

    public String inputMainMenu() {
        System.out.print(MAIN_MENU);
        return Reader.getString();
    }

    public List<String> inputOptions() {
        System.out.println(CHOOSE_OPTION);
        System.out.println(CHOOSE_OPTION_EXAMPLE);
        String options = Reader.getString();
        return List.of(options.split(", "));
    }
}
