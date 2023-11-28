package pairmatching.Domain;

import static pairmatching.Domain.Crew.BackendCrew.getBackendCrews;
import static pairmatching.Domain.Crew.FrontendCrew.getFrontendCrews;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MatchingResult {
    private String course;
    private String level;
    private String mission;
    private Set<Set<String>> result;

    public MatchingResult(String option) {
        List<String> dividedOption = divideOption(option);
        this.course = dividedOption.get(0);
        this.level = dividedOption.get(1);
        this.mission = dividedOption.get(2);
        this.result = new HashSet<>();
        makeMatchingResult();
    }

    private List<String> divideOption(String option) {
        return Arrays.asList(option.split(", "));
    }

    private void makeMatchingResult() {
        Set<String> crews = makeShuffledCrew(course);
        prepareResult(crews);
        while (!crews.isEmpty()) {
            Set<String> pair = new HashSet<>();
            pair.add(getRandomAndRemoveElement(crews));
            pair.add(getRandomAndRemoveElement(crews));
            result.add(pair);
        }
    }

    private Set<String> makeShuffledCrew(String course) {
        if (course.contains("백엔드")) {
            return new HashSet<>(Randoms.shuffle(getBackendCrews()));
        }
        return new HashSet<>(Randoms.shuffle(getFrontendCrews()));
    }

    private void prepareResult(Set<String> crews) {
        if (crews.size() % 2 != 0 && crews.size() >= 3) {
            Set<String> pair = new HashSet<>();
            pair.add(getRandomAndRemoveElement(crews));
            pair.add(getRandomAndRemoveElement(crews));
            pair.add(getRandomAndRemoveElement(crews));
            result.add(pair);
        }
    }

    private static <T> T getRandomAndRemoveElement(Set<T> set) {
        if (set.isEmpty()) {
            throw new IllegalArgumentException("Set is empty");
        }

        int randomIndex = new Random().nextInt(set.size());
        T randomElement = set.stream().skip(randomIndex).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Set is empty"));
        set.remove(randomElement);
        return randomElement;
    }

    public Set<Set<String>> getResult() {
        return Collections.unmodifiableSet(result);
    }
}
