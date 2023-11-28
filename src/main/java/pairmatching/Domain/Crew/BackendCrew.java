package pairmatching.Domain.Crew;


import static pairmatching.Common.Utility.readCrewNameFromResources;

import java.util.Collections;
import java.util.List;

public class BackendCrew {

    private static List<String> backendCrews;

    public BackendCrew() {
        BackendCrew.backendCrews = readCrewNameFromResources("backend-crew.md");
    }

    public static List<String> getBackendCrews() {
        if (backendCrews == null) {
            new BackendCrew();
        }
        return Collections.unmodifiableList(backendCrews);
    }
}
