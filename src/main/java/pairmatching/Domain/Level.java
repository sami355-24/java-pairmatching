package pairmatching.Domain;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private String name;

    Level(String name) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
