package pairmatching.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WoowaCourse {

    private Crews crews;
    private Set<Mission> missions;

    public WoowaCourse() {
        crews = new Crews();
        missions = new HashSet<>();
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
            missions.add(new Mission(missionName, level));
        }
    }
}
