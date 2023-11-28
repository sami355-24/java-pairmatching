package pairmatching.View;

import static pairmatching.Message.PairMatchingPrompt.SELECT_FUNCTION;

import pairmatching.View.IO.Printer;
import pairmatching.View.IO.Reader;

public class InputView {

    public int inputFunction() {
        Printer.printMessage(SELECT_FUNCTION);
        return Reader.getInt();
    }

}
