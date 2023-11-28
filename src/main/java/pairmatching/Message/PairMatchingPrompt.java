package pairmatching.Message;

public class PairMatchingPrompt {

    public static final String SELECT_FUNCTION = "실행할 기능을 선택하세요.\n"
            + "1. 페어 매칭\n"
            + "2. 페어 조회\n"
            + "3. 페어 초기화\n"
            + "Q. 종료";

    public static final String OPTION_SHOP = "#############################################";
    public static final String OPTION_COURSE = "과정: %s";
    public static final String OPTION_MISSION = "미션:";
    public static final String OPTION_MISSIONS = "  - %s: %s";

    public static final String INPUT_COURSE_LEVEL_MISSION = "과정, 레벨, 미션을 선택하세요.";
    public static final String INPUT_COURSE_LEVEL_MISSION_EXAMPLE = "ex) 백엔드, 레벨1, 자동차경주";
    public static final String ALREADY_EXIST_MATCHING_RESULT = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n네 | 아니오";
}
