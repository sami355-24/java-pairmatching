package pairmatching.Message.Excepton;


import static pairmatching.Message.Excepton.ExceptionPrefix.ERROR_PREFIX;

public enum ExceptionPrompt {
    INVALID_INPUT("유효하지 않은 입력입니다. 다시 입력해 주세요."),
    NOT_FOUND("매칭 이력이 없습니다."),
    RETRY("다른 미션을 진행합니다."),;

    private final String prompt;

    ExceptionPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return ERROR_PREFIX.getPrompt() + prompt;
    }
}