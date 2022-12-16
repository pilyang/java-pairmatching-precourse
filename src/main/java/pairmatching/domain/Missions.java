package pairmatching.domain;

import java.util.HashSet;
import java.util.Set;

public class Missions {

    private Set<Mission> missions;

    public Missions() {
        missions = new HashSet<>();
    }

    public void addMission(Level level, String missionName) {
        missions.add(new Mission(missionName, level));
    }
}
