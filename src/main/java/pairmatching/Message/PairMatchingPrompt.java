package pairmatching.Message;

public class PairMatchingPrompt {

    public static final String MAIN_MENU = """
            기능을 선택하세요.
            1. 페어 매칭
            2. 페어 조회
            3. 페어 초기화
            Q. 종료
            """;
    public static final String SHOP = "#############################################";
    public static final String COURSE_MENU = "과정: %s";
    public static final String MISSION_MENU = "미션:";
    public static final String MISSION_INFO = "- %s: %s";
    public static final String CHOOSE_OPTION = "과정, 레벨, 미션을 선택하세요";
    public static final String CHOOSE_OPTION_EXAMPLE = "ex) 과정, 레벨, 미션을 선택하세요.";
    public static final String PAIR_MATCHING_RESULT = "페어 매칭 결과입니다.";
    public static final String PAIR_MATCHING_AGAIN = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n네 | 아니오";
    public static final String PAIR_MATCHING_INIT = "초기화 되었습니다.";

    private PairMatchingPrompt() {
    }
}
