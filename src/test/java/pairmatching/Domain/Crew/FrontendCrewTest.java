package pairmatching.Domain.Crew;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FrontendCrewTest {

    @Test
    @DisplayName("프론트엔드 크루 이름들을 읽어들인다.")
    void getFrontendCrews() {
        FrontendCrew frontendCrew = new FrontendCrew();
        assertNotNull(frontendCrew.getFrontendCrews());
        frontendCrew.getFrontendCrews().forEach(System.out::println);
    }
}