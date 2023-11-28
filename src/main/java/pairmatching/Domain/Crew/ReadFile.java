package pairmatching.Domain.Crew;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class ReadFile {
    private static final String RESOURCE_PATH = "/";

    static List<String> readFileFromResources(String fileName) {
        return getResourceAsStream(fileName)
                .map(stream -> new BufferedReader(new InputStreamReader(stream)))
                .map(reader -> reader.lines().collect(Collectors.joining("\n")))
                .map(Collections::singletonList)
                .orElse(Collections.emptyList());
    }

    private static Optional<InputStream> getResourceAsStream(String fileName) {
        String filePath = RESOURCE_PATH + fileName;
        return Optional.ofNullable(ReadFile.class.getResourceAsStream(filePath));
    }
}
