package pairmatching.Domain.Guide;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GuideTest {

    @Test
    @DisplayName("가이드 파일을 읽어들인다.")
    void makeGuide() throws Exception {
        Guide guide = new Guide();

        assertNotNull(guide.getCourses());
        assertNotNull(guide.getLevels());
        assertNotNull(guide.getMissionsPerLevel());

        guide.getCourses().forEach(System.out::println);
        System.out.println();

        guide.getLevels().forEach(System.out::println);
        System.out.println();

        Map<String, MissionGroup> missionsPerLevel = guide.getMissionsPerLevel();
        missionsPerLevel.forEach((level, missionGroup) -> {
            System.out.println(level);
            missionGroup.getMissions().forEach(System.out::println);
        });
    }

}