package pairmatching.Domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static List<String> findAllName(){
        return Arrays.stream(Course.values())
                .map(course -> course.name)
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }
    // 추가 기능 구현
}