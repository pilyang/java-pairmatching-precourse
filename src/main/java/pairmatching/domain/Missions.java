package pairmatching.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Missions {

    private Set<Mission> missions;

    public Missions() {
        missions = new HashSet<>();
    }

    public void addMission(Level level, String missionName) {
        missions.add(new Mission(missionName, level));
    }

    public List<String> getNameOfMissions(Level level) {
        return missions.stream()
                .filter(mission -> mission.isMissionLevel(level))
                .map(mission -> mission.getName())
                .collect(Collectors.toList());
    }
}
