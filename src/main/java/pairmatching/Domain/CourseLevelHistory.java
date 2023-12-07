package pairmatching.Domain;

import static pairmatching.Domain.Course.BACKEND;
import static pairmatching.Domain.Course.FRONTEND;
import static pairmatching.Domain.Level.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseLevelHistory {

    private Map<String, Set<Pair>> history;
    private static CourseLevelHistory instance;

    private CourseLevelHistory() {
        this.history = new HashMap<>();
        initHistory(FRONTEND);
        initHistory(BACKEND);
    }

    public static CourseLevelHistory getInstance() {
        if (instance == null) {
            instance = new CourseLevelHistory();
        }
        return instance;
    }

    private void initHistory(Course course) {
        for (Level value : Level.values()) {
            history.put(course.getName() + value.getName(), Set.of());
        }
    }

    public boolean hasMatchedPair(String course, String level, Set<Pair> candidatePair) {
        Set<Pair> pairSet = history.get(course + level);
        for (Pair pair1 : pairSet) {
            for (Pair pair2 : candidatePair) {
                if (pair1.equals(pair2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addHistory(String course, String level, Set<Pair> pairs) {
        history.put(course + level, Set.copyOf(pairs));
    }
}
