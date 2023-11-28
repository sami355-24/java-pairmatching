package pairmatching.Domain.Crew;

import static pairmatching.Domain.Crew.ReadFile.readFileFromResources;

import java.util.Collections;
import java.util.List;

public class BackendCrew {

    private List<String> backendCrews;

    private BackendCrew(List<String> backendCrews) {
        this.backendCrews = readFileFromResources("backend-crew.md");
    }

    public List<String> getBackendCrews() {
        return Collections.unmodifiableList(backendCrews);
    }
}
