package pairmatching.Domain;

import static pairmatching.Common.Utility.readFile;

import java.util.ArrayList;
import java.util.List;

public class CrewGroup {
    private final List<Crew> backendCrews = new ArrayList<>();
    private final List<Crew> frontendCrews = new ArrayList<>();

    public CrewGroup(){
        List<String> backendCrews = readFile("backend_crew.md");
        List<String> frontendCrews = readFile("frontend_crew.md");
        backendCrews.forEach(crew -> this.backendCrews.add(new Crew(Course.BACKEND, crew)));
        frontendCrews.forEach(crew -> this.frontendCrews.add(new Crew(Course.FRONTEND, crew)));
    }
}
