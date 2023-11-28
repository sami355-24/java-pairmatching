package pairmatching.Domain.Crew;

import static pairmatching.Domain.Crew.ReadFile.readFileFromResources;

import java.util.Collections;
import java.util.List;

public class FrontendCrew {

    private List<String> frontendCrews;

    public FrontendCrew() {
        this.frontendCrews = readFileFromResources("frontend-crew.md");
    }

    public List<String> getFrontendCrews() {
        return Collections.unmodifiableList(frontendCrews);
    }
}
