package pairmatching.View.IO;


import static pairmatching.Message.Excepton.ExceptionPrompt.INVALID_INPUT;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.Exception.CommonValidateException;

public class Reader {

    private Reader() {
    }

    public static int getInt() {
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new CommonValidateException(INVALID_INPUT.getPrompt(), e);
        }
    }

    public static String getString() {
        String input = Console.readLine();
        validateInput(input);
        return input;
    }

    private static void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new CommonValidateException(INVALID_INPUT.getPrompt(), new IllegalArgumentException());
        }
    }
}
