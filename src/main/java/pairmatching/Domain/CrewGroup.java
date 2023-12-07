package pairmatching.Domain;

import static pairmatching.Common.Utility.readFile;
import static pairmatching.Domain.Course.BACKEND;
import static pairmatching.Domain.Course.FRONTEND;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class CrewGroup {

    private List<Crew> frontendCrews;
    private List<Crew> backendCrews;

    public CrewGroup() {
        makeCrews();
    }

    private void makeCrews(){
        List<String> feCrewNames = readFile("frontend-crew.md");
        frontendCrews = feCrewNames.stream()
                .map(name -> new Crew(FRONTEND, name))
                .collect(Collectors.toList());

        List<String> beCrewNames = readFile("backend-crew.md");
        backendCrews = beCrewNames.stream()
                .map(name -> new Crew(BACKEND, name))
                .collect(Collectors.toList());
    }

    public List<String> findShuffledCrew(Course course){
        List<Crew> shuffled = new LinkedList<>();
        if (course == FRONTEND) {
            shuffled = Randoms.shuffle(frontendCrews);
        }
        if (course == BACKEND) {
            shuffled = Randoms.shuffle(backendCrews);
        }

        return shuffled.stream()
                .map(Crew::getName)
                .collect(Collectors.toList());
    }
}
