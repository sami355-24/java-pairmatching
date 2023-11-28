package pairmatching.Message.Excepton;


import static pairmatching.Message.Excepton.ExceptionPrefix.ERROR_PREFIX;

public enum ExceptionPrompt {
    INVALID_INPUT("유효하지 않은 입력입니다. 다시 입력해 주세요."),
    CAN_NOT_MATCHED("3회 이상 매칭이 되지 않았거나 매칭을 할 수 있는 경우의 수가 없습니다.");

    private final String prompt;

    ExceptionPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return ERROR_PREFIX.getPrompt() + prompt;
    }
}