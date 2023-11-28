package pairmatching.Domain.Crew;


import static pairmatching.Common.Utility.readCrewNameFromResources;

import java.util.Collections;
import java.util.List;

public class FrontendCrew {

    private static List<String> frontendCrews;

    public FrontendCrew() {
        FrontendCrew.frontendCrews = readCrewNameFromResources("frontend-crew.md");
    }

    public static List<String> getFrontendCrews() {
        if (frontendCrews == null) {
            new FrontendCrew();
        }
        return Collections.unmodifiableList(frontendCrews);
    }
}
