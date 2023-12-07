package pairmatching.Domain;

import static pairmatching.Common.Utility.readFile;
import static pairmatching.Domain.Course.BACKEND;
import static pairmatching.Domain.Course.FRONTEND;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class CrewGroup {

    private List<Crew> frontendCrews;
    private List<Crew> backendCrews;
    private static CrewGroup instance;

    private CrewGroup() {
        makeCrews();
    }

    public static CrewGroup getInstance(){
        if (instance == null) {
            instance = new CrewGroup();
        }
        return instance;
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

    public Set<Pair> makePairsByCourse(Course course){
        Set<Pair> randomPairs = new LinkedHashSet<>();
        Queue<Crew> shuffledCrew = findShuffledCrew(course);
        while (shuffledCrew.size() > 3){
            Pair pair = new Pair(shuffledCrew.poll(), shuffledCrew.poll());
            randomPairs.add(pair);
        }
        randomPairs.add(new Pair(shuffledCrew));
        return randomPairs;
    }

    private Queue<Crew> findShuffledCrew(Course course){
        List<Crew> shuffled = new LinkedList<>();
        if (course == FRONTEND) {
            shuffled = Randoms.shuffle(frontendCrews);
        }
        if (course == BACKEND) {
            shuffled = Randoms.shuffle(backendCrews);
        }
        return new LinkedList<>(shuffled);
    }
}
