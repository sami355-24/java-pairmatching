package pairmatching.Domain.Guide;

import static pairmatching.Common.Utility.readCrewNameFromResources;
import static pairmatching.Common.Utility.readGuidesBetweenSections;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Guide {

    private List<String> courses;
    private List<String> levels;
    private Map<String, MissionGroup> missionsPerLevel;

    public Guide() {
        getCourses("guide.md");
        getMissions("guide.md");
    }

    private void getCourses(String guideFileName) {
        readCrewNameFromResources(guideFileName);
        this.courses = readGuidesBetweenSections("## 과정", "## 레벨");
    }

    private void getMissions(String guideFileName) {
        missionsPerLevel = new LinkedHashMap<>();
        this.levels = readGuidesBetweenSections("## 레벨", "## 미션");
        substringLevels();
        for (int i = 0; i < levels.size() - 1; i++) {
            String first = levels.get(i);
            String second = levels.get(i + 1);
            MissionGroup missionGroup = new MissionGroup(readGuidesBetweenSections("### " + first, "### " + second));
            missionsPerLevel.put(first, substringMissionGroup(missionGroup.getMissions()));
        }
        List<String> lastSections = readGuidesLastSections("### " + levels.get(levels.size() - 1));
        missionsPerLevel.put(levels.get(levels.size() - 1), substringMissionGroup(lastSections));
    }

    private void substringLevels() {
        this.levels = levels.stream()
                .map(level -> level.substring(2))
                .collect(Collectors.toList());
    }

    private MissionGroup substringMissionGroup(List<String> missions) {
        return new MissionGroup(missions.stream()
                .map(mission -> mission.substring(2))
                .collect(Collectors.toList()));
    }
    private List<String> readGuidesLastSections(String sectionHeader) {
        return readGuidesBetweenSections(sectionHeader, "");
    }

    public List<String> getCourses() {
        return Collections.unmodifiableList(courses);
    }

    public List<String> getLevels() {
        return Collections.unmodifiableList(levels);
    }

    public Map<String, MissionGroup> getMissionsPerLevel() {
        return Collections.unmodifiableMap(missionsPerLevel);
    }
}
