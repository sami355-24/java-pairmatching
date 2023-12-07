package pairmatching.Domain;

import static pairmatching.Domain.Course.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class CourseLevelMissionHistory {

    private Map<String, LinkedHashSet<Pair>> history;
    private static CourseLevelMissionHistory instance;

    private CourseLevelMissionHistory() {
        history = new HashMap<>();
        initHistory(FRONTEND);
        initHistory(BACKEND);
    }

    public static CourseLevelMissionHistory getInstance(){
        if (instance == null) {
            instance = new CourseLevelMissionHistory();
        }
        return instance;
    }

    private void initHistory(Course course) {
        for (Level level : Level.values()) {
            for (Mission mission : Mission.values()) {
                history.put(course.getName() + level.getName() + mission.getName(), new LinkedHashSet<>());
            }
        }
    }

    public boolean hasMatchedPair(String course, String level, String mission) {
        return !history.get(course + level + mission).isEmpty();
    }

    public void addHistory(String course, String level, String mission, Set<Pair> pairs) {
        history.put(course + level + mission, new LinkedHashSet<>(pairs));
    }

    public Set<Pair> getHistory(Course course, Level level, Mission mission) {
        return Collections.unmodifiableSet(history.get(course.getName() + level.getName() + mission.getName()));
    }
}
