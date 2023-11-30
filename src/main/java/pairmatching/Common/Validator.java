package pairmatching.Common;


import static pairmatching.Message.Excepton.ExceptionPrompt.INVALID_INPUT;

import pairmatching.Exception.CommonValidateException;

public class Validator {

    private static final String number = "^\\d*$";
    private static final String englishWithWhiteSpace = "^[a-zA-Z ]*$";
    private static final String koreanWithWhiteSpace = "^[가-힣 ]*$";
    private static final String whiteSpace = " ";

    private Validator() {
    }

    public static void hasOnlyNumber(String str) {
        if (!str.matches(number)) {
            throw new CommonValidateException(INVALID_INPUT.getPrompt(), new IllegalArgumentException());
        }
    }

    public static void hasOnlyEnglish(String str) {
        if (!str.matches(englishWithWhiteSpace)) {
            throw new CommonValidateException(INVALID_INPUT.getPrompt(), new IllegalArgumentException());
        }
    }

    public static void hasOnlyKorean(String str) {
        if (!str.matches(koreanWithWhiteSpace)) {
            throw new CommonValidateException(INVALID_INPUT.getPrompt(), new IllegalArgumentException());
        }
    }

    public static void hasWhiteSpace(String str) {
        if (str.contains(whiteSpace)) {
            throw new CommonValidateException(INVALID_INPUT.getPrompt(), new IllegalArgumentException());
        }
    }

    public static void isEmptyInput(String str) {
        if (str.isEmpty()) {
            throw new CommonValidateException(INVALID_INPUT.getPrompt(), new IllegalArgumentException());
        }
    }

}
