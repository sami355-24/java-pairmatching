package pairmatching.Domain;

import static pairmatching.Domain.Mission.*;

import java.util.List;

public enum Level {
    LEVEL1("레벨1", List.of("자동차경주", "로또", "숫자야구")),
    LEVEL2("레벨2", List.of("장바구니", "결제", "지하철노선도")),
    LEVEL3("레벨3", List.of()),
    LEVEL4("레벨4", List.of("성능개선", "배포")),
    LEVEL5("레벨5", List.of());

    private String name;
    private List<String> missions;

    Level(String name, List<String> missions) {
        this.name = name;
        this.missions = missions;
    }

    public static void validateLevel(String level) {
        if (level.equals(LEVEL1.getName()) ||
                level.equals(LEVEL2.getName()) ||
                level.equals(LEVEL3.getName()) ||
                level.equals(LEVEL4.getName()) ||
                level.equals(LEVEL5.getName())) {
            return;
        }
        throw new IllegalArgumentException("존재하지 않는 레벨입니다.");
    }

    public static void validateMissionInLevel(String level, String mission) {
        Level findLevel = findLevelByName(level);
        if (!findLevel.missions.contains(mission)) {
            throw new IllegalArgumentException("존재하지 않는 미션입니다.");
        }
    }

    private static Level findLevelByName(String levelName) {
        for (Level level : Level.values()) {
            if (level.getName().equals(levelName)) {
                return level;
            }
        }
        throw new IllegalArgumentException("예외 발생");
    }

    public String getName() {
        return name;
    }
}
