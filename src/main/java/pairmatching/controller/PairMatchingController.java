package pairmatching.controller;

import pairmatching.constant.FileSource;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.ProgramFunction;
import pairmatching.domain.WoowaCourse;
import pairmatching.util.RepeatValidator;
import pairmatching.view.FileInputView;
import pairmatching.view.InputView;

import java.io.IOException;
import java.util.List;

public class PairMatchingController {

    private final FileInputView fileInputView;
    private final InputView inputView;

    private final WoowaCourse woowaCourse;

    public PairMatchingController() throws IOException {
        woowaCourse = new WoowaCourse();
        fileInputView = new FileInputView();
        inputView = new InputView();

        initCourse();
    }

    public void initCourse() throws IOException {
        addCrewsFromFile();
        addMissionsFromFile();
    }

    private void addCrewsFromFile() throws IOException {
        List<String> backendCrewNames = fileInputView.readLinesFromFile(FileSource.BACKEND_CREW_SOURCE_FILE);
        List<String> frontendCrewNames = fileInputView.readLinesFromFile(FileSource.FRONTEND_CREW_SOURCE_FILE);
        try {
            woowaCourse.addCrews(Course.BACKEND, backendCrewNames);
            woowaCourse.addCrews(Course.FRONTEND, frontendCrewNames);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void addMissionsFromFile() throws IOException {
        for (Level level : Level.values()) {
            List<String> missionNames = fileInputView.readLinesFromFile(level.getMissionFileSource());
            woowaCourse.addMissions(level, missionNames);
        }
    }

    public void startProgram() {
        ProgramFunction nextFunction;
        do {
            nextFunction = readNextFunction();
        } while (!nextFunction.equals(ProgramFunction.QUIT));
    }

    private ProgramFunction readNextFunction() {
        return RepeatValidator.readUntilValidate(() -> inputView.readNextFunction());
    }

}
