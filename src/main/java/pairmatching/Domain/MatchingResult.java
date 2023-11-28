package pairmatching.Domain;

import static pairmatching.Domain.Crew.BackendCrew.getBackendCrews;
import static pairmatching.Domain.Crew.FrontendCrew.getFrontendCrews;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import pairmatching.Domain.Crew.BackendCrew;
import pairmatching.Domain.Crew.FrontendCrew;

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
        this.result = new LinkedHashSet<>();
        makeMatchingResult();
    }

    private List<String> divideOption(String option) {
        return Arrays.asList(option.split(", "));
    }

    private void makeMatchingResult() {
        Set<String> crews = makeShuffledCrew(course);
        String courseName = course;
        while (crews.size() > 3) {
            Set<String> pair = new HashSet<>();
            String pair1 = getRandomAndRemoveElement(crews);
            String pair2 = getRandomAndRemoveElement(crews);
            checkPair(pair1, pair2, courseName);
            pair.add(pair1);
            pair.add(pair2);
            addResult(pair);
        }
        isLeftCrewIsMoreThanThree(crews);
    }

    private Set<String> makeShuffledCrew(String course) {
        if (course.contains("백엔드")) {
            return new HashSet<>(Randoms.shuffle(getBackendCrews()));
        }
        return new HashSet<>(Randoms.shuffle(getFrontendCrews()));
    }

    private void isLeftCrewIsMoreThanThree(Set<String> crews) {
        if (crews.size() % 2 != 0 && crews.size() >= 3) {
            Set<String> pair = new HashSet<>();
            pair.add(getRandomAndRemoveElement(crews));
            pair.add(getRandomAndRemoveElement(crews));
            pair.add(getRandomAndRemoveElement(crews));
            addResult(pair);
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

    private void checkPair(String pair1, String pair2, String courseName) {
        if (courseName.contains("백엔드")) {
            if (BackendCrew.isNeverPaired(pair1, pair2)) {
                throw new IllegalArgumentException("이미 짝인 백엔드 크루입니다.");
            }
        }
        if (courseName.contains("프론트엔드")) {
            if (FrontendCrew.isNeverPaired(pair1, pair2)) {
                throw new IllegalArgumentException("이미 짝인 프론트엔드 크루입니다.");
            }
        }
    }

    private void addResult(Set<String> pair) {
        List<String> pairList = new ArrayList<>(pair);
        int pairSize = pairList.size();
        for (int i = 0; i < pairSize; i++) {
            for (int j = i + 1; j < pairSize; j++) {
                addBlackList(pairList.get(i), pairList.get(j));
            }
        }
        result.add(pair);
    }

    private void addBlackList(String pair1, String pair2) {
        if (course.contains("백엔드")) {
            BackendCrew.addBlackList(pair1, pair2);
            BackendCrew.addBlackList(pair2, pair1);
        }
        if (course.contains("프론트엔드")) {
            FrontendCrew.addBlackList(pair1, pair2);
            FrontendCrew.addBlackList(pair2, pair1);
        }
    }

    public Set<Set<String>> getResult() {
        return Collections.unmodifiableSet(result);
    }
}
