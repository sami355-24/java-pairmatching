package pairmatching.Domain;

import static pairmatching.Common.Utility.readFile;
import static pairmatching.Domain.Course.BACKEND;
import static pairmatching.Domain.Course.FRONTEND;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CrewGroup {

    private Set<Crew> frontendCrews;
    private Set<Crew> backendCrews;

    public CrewGroup() {
        makeCrews();
    }

    private void makeCrews(){
        List<String> feCrewNames = readFile("frontend-crew.md");
        frontendCrews = feCrewNames.stream()
                .map(name -> new Crew(FRONTEND, name))
                .collect(Collectors.toSet());

        List<String> beCrewNames = readFile("backend-crew.md");
        backendCrews = beCrewNames.stream()
                .map(name -> new Crew(BACKEND, name))
                .collect(Collectors.toSet());
    }
}
