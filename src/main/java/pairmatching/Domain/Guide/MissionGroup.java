package pairmatching.Domain.Guide;

import java.util.Collections;
import java.util.List;

public class MissionGroup {
    private List<String> missions;

    public MissionGroup(List<String> missions) {
        this.missions = missions;
    }

    public List<String> getMissions() {
        return Collections.unmodifiableList(missions);
    }
}
