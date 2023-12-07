package pairmatching.Domain;

import static pairmatching.Domain.Course.BACKEND;
import static pairmatching.Domain.Course.FRONTEND;
import static pairmatching.Domain.Level.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CourseLevelHistory {

    private Map<String, Set<Pair>> history;

    public CourseLevelHistory() {
        this.history = new HashMap<>();
        initHistory(FRONTEND);
        initHistory(BACKEND);
    }

    private void initHistory(Course course) {
        for (Level value : Level.values()) {
            history.put(course.getName()+value.getName(), Set.of());
        }
    }



}
