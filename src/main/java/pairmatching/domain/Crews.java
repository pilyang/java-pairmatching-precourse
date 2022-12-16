package pairmatching.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Crews {

    private static final String NAME_DUPLICATE_EXCEPTION_MESSAGE = "[ERROR] 중복된 이름의 크루가 있습니다.";

    Set<Crew> crews;

    public Crews() {
        crews = new HashSet<>();
    }

    public void addBackendCrews(List<String> names) {
        for (String name : names) {
            addCrew(new Crew(name, Course.BACKEND));
        }
    }

    public void addFrontendCrews(List<String> names) {
        for (String name : names) {
            addCrew(new Crew(name, Course.FRONTEND));
        }
    }

    private void addCrew(Crew crew) {
        validateCrewName(crew);
        crews.add(crew);
    }

    private void validateCrewName(Crew crew) {
        if (crews.contains(crew)) {
            throw new IllegalArgumentException(NAME_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }
}
