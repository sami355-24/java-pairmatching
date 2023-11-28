package pairmatching.Domain.Crew;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BackendCrewTest {

    @Test
    @DisplayName("백엔드 크루 이름들을 읽어들인다.")
    void getBackendCrews() {
        BackendCrew backendCrew = new BackendCrew();
        assertNotNull(backendCrew.getBackendCrews());
        backendCrew.getBackendCrews().forEach(System.out::println);
    }
}