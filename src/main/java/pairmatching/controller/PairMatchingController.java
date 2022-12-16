package pairmatching.controller;

import pairmatching.constant.FileSource;
import pairmatching.domain.Course;
import pairmatching.domain.WoowaCourse;
import pairmatching.view.FileInputView;

import java.io.IOException;
import java.util.List;

public class PairMatchingController {

    private final FileInputView fileInputView;

    private final WoowaCourse woowaCourse;

    public PairMatchingController() {
        woowaCourse = new WoowaCourse();
        fileInputView = new FileInputView();
    }

    public void addCrewsFromFile() throws IOException {
        List<String> backendCrewNames = fileInputView.readCrewNamesFromFile(FileSource.BACKEND_CREW_SOURCE_FILE);
        List<String> frontendCrewNames = fileInputView.readCrewNamesFromFile(FileSource.FRONTEND_CREW_SOURCE_FILE);
        try {
            woowaCourse.addCrews(Course.BACKEND, backendCrewNames);
            woowaCourse.addCrews(Course.FRONTEND, frontendCrewNames);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

}
