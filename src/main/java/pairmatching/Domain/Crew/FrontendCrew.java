package pairmatching.Domain.Crew;


import static pairmatching.Common.Utility.readCrewNameFromResources;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FrontendCrew {

    private static List<String> frontendCrews;
    private static Map<String, Set<String>> blackLists = new HashMap<>();

    public FrontendCrew() {
        FrontendCrew.frontendCrews = readCrewNameFromResources("frontend-crew.md");
        initBlackLists();
    }

    private static void initBlackLists() {
        for (String frontCrew : frontendCrews) {
            blackLists.put(frontCrew, new HashSet<>());
        }
    }

    public static boolean isNeverPaired(String pair1, String pair2) {
        Set<String> blackList1 = blackLists.get(pair1);
        Set<String> blackList2 = blackLists.get(pair2);
        return blackList1.contains(pair2) && blackList2.contains(pair1);
    }

    public static void addBlackList(String pair1, String pair2) {
        blackLists.get(pair1).add(pair2);
        blackLists.get(pair2).add(pair1);
    }

    public static List<String> getFrontendCrews() {
        if (frontendCrews == null) {
            new FrontendCrew();
        }
        return Collections.unmodifiableList(frontendCrews);
    }
}
