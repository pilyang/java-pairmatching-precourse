package pairmatching.view;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Missions;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String MISSION_INFO_DIVIDER = "############################################";
    private static final String COURSE_INFO_FORMAT = "과정: %s";
    private static final String MISSION_INFO_HEAD = "미션:";
    private static final String MISSION_INFO_FORMAT = "  - %s: %s";
    private static final String ELEMENT_DIVIDER = " | ";

    public void printCourseAndMissionTable(List<Course> courses, Missions missions) {
        System.out.println(MISSION_INFO_DIVIDER);
        printCourses(courses);
        printMissions(missions);
        System.out.println(MISSION_INFO_DIVIDER);
    }

    private void printMissions(Missions missions) {
        System.out.println(MISSION_INFO_HEAD);
        for(Level level : Level.values()) {
            List<String> missionNames = missions.getNameOfMissions(level);
            System.out.println(String.format(MISSION_INFO_FORMAT, level, makeElementTable(missionNames)));
        }
    }

    private void printCourses(List<Course> courses) {
        List<String> courseNames = courses.stream().map(course -> course.getName()).collect(Collectors.toList());
        System.out.println(String.format(COURSE_INFO_FORMAT, makeElementTable(courseNames)));
    }

    private String makeElementTable(List<String> elements) {
        return String.join(ELEMENT_DIVIDER, elements);
    }
}
