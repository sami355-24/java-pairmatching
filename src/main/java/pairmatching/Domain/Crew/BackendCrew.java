package pairmatching.Domain.Crew;


import static pairmatching.Common.Utility.readCrewNameFromResources;

import java.util.Collections;
import java.util.List;

public class BackendCrew {

    private List<String> backendCrews;

    public BackendCrew() {
        this.backendCrews = readCrewNameFromResources("backend-crew.md");
    }

    public List<String> getBackendCrews() {
        return Collections.unmodifiableList(backendCrews);
    }
}
