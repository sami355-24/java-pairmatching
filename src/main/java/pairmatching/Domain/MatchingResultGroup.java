package pairmatching.Domain;

import java.util.HashMap;
import java.util.Map;

public class MatchingResultGroup {
    private final Map<String, MatchingResult> matchingResultGroup;

    public MatchingResultGroup() {
        this.matchingResultGroup = new HashMap<>();
    }

    public void addMatchingResult(String id, MatchingResult matchingResult) {
        matchingResultGroup.put(id, matchingResult);
    }

    public boolean isExistMatchingResult(String id) {
        return matchingResultGroup.containsKey(id);
    }

    public MatchingResult findMatchingResult(String id) {
        return matchingResultGroup.get(id);
    }

}
