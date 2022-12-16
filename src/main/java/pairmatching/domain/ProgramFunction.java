package pairmatching.domain;

import java.util.Arrays;

public enum ProgramFunction {
    MATCHING("1", "페어 매칭"),
    LOOKUP("2", "페어 조회"),
    INIT("3", "페어 초기화"),
    QUIT("Q", "종료");

    private static final String COMMAND_NOT_FOUND_ERROR = "[ERROR] 해당하는 커맨드가 없습니다.";

    private final String command;
    private final String meaning;

    ProgramFunction(String command, String meaning) {
        this.command = command;
        this.meaning = meaning;
    }

    public static ProgramFunction findByCommand(String command) {
        return Arrays.stream(ProgramFunction.values())
                .filter(programFunction -> programFunction.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(COMMAND_NOT_FOUND_ERROR));
    }

    @Override
    public String toString() {
        return command + ". " + meaning;
    }
}
