package pairmatching.Domain.Crew;


import static pairmatching.Common.Utility.readCrewNameFromResources;

import java.util.Collections;
import java.util.List;

public class FrontendCrew {

    private List<String> frontendCrews;

    public FrontendCrew() {
        this.frontendCrews = readCrewNameFromResources("frontend-crew.md");
    }

    public List<String> getFrontendCrews() {
        return Collections.unmodifiableList(frontendCrews);
    }
}
