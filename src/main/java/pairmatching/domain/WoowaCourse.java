package pairmatching.domain;

import java.util.List;

public class WoowaCourse {

    private Crews crews;
    private Missions missions;

    public WoowaCourse() {
        crews = new Crews();
        missions = new Missions();
    }

    // todo: course 추가시 코드 수정이 필요 없도록 -> 아마 enum을 수정하는거로 해결 가능할듯
    public void addCrews(Course course, List<String> names) {
        if (course.equals(Course.BACKEND)) {
            crews.addBackendCrews(names);
        }
        if (course.equals(Course.FRONTEND)) {
            crews.addFrontendCrews(names);
        }
    }

    public void addMissions(Level level, List<String> missionNames) {
        for (String missionName : missionNames) {
            missions.addMission(level, missionName);
        }
    }

    public Missions getMissions() {
        return missions;
    }
}
