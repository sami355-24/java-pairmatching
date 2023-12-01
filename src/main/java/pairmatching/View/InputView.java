package pairmatching.View;

import static pairmatching.Message.PairMatchingPrompt.MAIN_MENU;

import pairmatching.View.IO.Reader;

public class InputView {

    public String inputMainMenu(){
        System.out.println(MAIN_MENU);
        return Reader.getString();
    }
}
