package pairmatching.domain;

public class Mission {

    private final String name;
    private final Level level;

    public Mission(String name, Level level) {
        this.name = name;
        this.level = level;
    }

    public boolean isMissionLevel(Level level) {
        return this.level.equals(level);
    }

    public String getName() {
        return name;
    }
}
