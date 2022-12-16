package pairmatching.domain;

import pairmatching.constant.FileSource;

import java.util.Arrays;

public enum Level {
    LEVEL1("레벨1", FileSource.LEVEL1_MISSION_SOURCE_FILE),
    LEVEL2("레벨2", FileSource.LEVEL2_MISSION_SOURCE_FILE),
    LEVEL3("레벨3", FileSource.LEVEL3_MISSION_SOURCE_FILE),
    LEVEL4("레벨4", FileSource.LEVEL4_MISSION_SOURCE_FILE),
    LEVEL5("레벨5", FileSource.LEVEL5_MISSION_SOURCE_FILE);

    private static final String LEVEL_NOT_FOUND_EXCEPTION_MESSAGE = "[ERROR] 해당 레벨을 찾을 수 없습니다.";

    private final String name;
    private final String missionFileSource;

    Level(String name, String missionFileSource) {
        this.name = name;
        this.missionFileSource = missionFileSource;
    }

    public static Level findByName(String name) {
        return Arrays.stream(Level.values())
                .filter(level -> level.name.equals(level))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(LEVEL_NOT_FOUND_EXCEPTION_MESSAGE));
    }

    public String getMissionFileSource() {
        return missionFileSource;
    }

    @Override
    public String toString() {
        return name;
    }
}
