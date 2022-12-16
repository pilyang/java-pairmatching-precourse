package pairmatching.domain;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private static final String NAME_NOT_FOUND_EXCEPTION_MESSAGE = "[ERROR] 해당하는 이름의 코스를 찾을 수 없습니다.";

    private final String name;

    Course(String name) {
        this.name = name;
    }

    public static Course findByName(String name) {
        return Arrays.stream(Course.values())
                .filter(course -> course.name.equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
    }
}