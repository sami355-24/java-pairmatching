package pairmatching.Domain.Crew;


import static pairmatching.Common.Utility.readCrewNameFromResources;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import pairmatching.Domain.Level;

public class BackendCrew {

    private static List<String> backendCrews;
    private static Map<String, Map<String, Set<String>>> blackLists = new HashMap<>();

    public BackendCrew() {
        BackendCrew.backendCrews = readCrewNameFromResources("backend-crew.md");
        initBlackLists();
    }

    private static void initBlackLists() {
        List<String> levels = Level.levels;
        for (String level : levels) {
            Map<String, Set<String>> temp = new HashMap<>();
            for (String backendCrew : backendCrews) {
                temp.put(backendCrew, new HashSet<>());
            }
            blackLists.put(level, temp);
        }

    }
    public static boolean isPairedInPast(String pair1, String pair2, String level) {
        Map<String, Set<String>> findblackListByLevel = blackLists.get(level);
        Set<String> blackList1 = findblackListByLevel.get(pair1);
        Set<String> blackList2 = findblackListByLevel.get(pair2);
        return (blackList1.contains(pair2) || blackList2.contains(pair1));
    }

    public static void addBlackList(String pair1, String pair2, String level) {
        Map<String, Set<String>> blackListPerLevel = blackLists.get(level);
        blackListPerLevel.get(pair1).add(pair2);
        blackListPerLevel.get(pair2).add(pair1);
    }

    public static List<String> getBackendCrews() {
        if (backendCrews == null) {
            new BackendCrew();
        }
        return Collections.unmodifiableList(backendCrews);
    }
}
