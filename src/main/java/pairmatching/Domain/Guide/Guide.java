package pairmatching.Domain.Guide;

import static pairmatching.Common.Utility.readCrewNameFromResources;

import java.util.List;
import java.util.Map;

public class Guide {

    private List<String> courses;
    private Map<String, MissionGroup> missions;

    public Guide(String guideFileName) {
        getCourses(guideFileName);
    }

    private void getCourses(String guideFileName) {
        readCrewNameFromResources(guideFileName);

    }
}
