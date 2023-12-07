package pairmatching.Domain;

import static pairmatching.Message.Excepton.ExceptionPrompt.INVALID_INPUT;

import pairmatching.Exception.InvalidInputException;

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
        throw new InvalidInputException(INVALID_INPUT.getPrompt(), new IllegalArgumentException());
    }

    public static Course findCourse(String course) {
        if (course.equals(BACKEND.getName())) {
            return BACKEND;
        }
        return FRONTEND;
    }

    public String getName() {
        return name;
    }
}