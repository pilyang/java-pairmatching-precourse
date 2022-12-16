package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.ProgramFunction;

public class InputView {

    private static final String FUNCTION_INPUT_INFO_MESSAGE = "기능을 선택하세요.";

    public ProgramFunction readNextFunction() {
        printAvailableFunctions();
        String commandInput = Console.readLine();

        return ProgramFunction.findByCommand(commandInput);
    }

    private void printAvailableFunctions() {
        System.out.println(FUNCTION_INPUT_INFO_MESSAGE);
        for (ProgramFunction programFunction : ProgramFunction.values()) {
            System.out.println(programFunction);
        }
    }

}
