package pairmatching.Message;

public class Prompt {

    public static final String FRONT_MENU = """
            기능을 선택하세요.
            1. 페어 매칭
            2. 페어 조회
            3. 페어 초기화
            Q. 종료""";

    public static final String PAIR_MATCH_MENU = """
            #############################################
            과정: 백엔드 | 프론트엔드
            미션:
              - 레벨1: 자동차경주 | 로또 | 숫자야구게임
              - 레벨2: 장바구니 | 결제 | 지하철노선도
              - 레벨3:
              - 레벨4: 성능개선 | 배포
              - 레벨5:
            ############################################
            """;

    public static final String COURSE_LEVEL_MISSION = """
            과정, 레벨, 미션을 선택하세요.
            ex) 백엔드, 레벨1, 자동차경주""";

    public static final String ASK_RETRY = """
            매칭 정보가 있습니다. 다시 매칭하시겠습니까?
            네 | 아니오
            """;
}
