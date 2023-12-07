package pairmatching.Domain;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static void validateCourse(String course) {
        if (course.equals(BACKEND.getName()) || course.equals(FRONTEND.getName())) {
            return;
        }
        throw new IllegalArgumentException("존재하지 않는 코스입니다.");
    }

    public String getName() {
        return name;
    }
    // 추가 기능 구현
}