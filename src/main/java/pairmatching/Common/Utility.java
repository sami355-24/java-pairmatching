package pairmatching.Common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Utility {

    private Utility(){
    }

    public static int convertStringToInt(String str) {
        return Integer.parseInt(str);
    }

    private static final String RESOURCE_PATH = "/";

    private static Optional<InputStream> getResourceAsStream(String fileName) {
        String filePath = RESOURCE_PATH + fileName;
        return Optional.ofNullable(Utility.class.getResourceAsStream(filePath));
    }

    public static List<String> readCrewNameFromResources(String fileName) {
        return getResourceAsStream(fileName)
                .map(stream -> new BufferedReader(new InputStreamReader(stream)))
                .map(reader -> reader.lines().collect(Collectors.joining("\n")))
                .map(Collections::singletonList)
                .orElse(Collections.emptyList());
    }


    public static List<String> readGuidesBetweenSections(String start, String end) {
        return getResourceAsStream("guide.md")
                .map(inputStream -> new BufferedReader(new InputStreamReader(inputStream)))
                .map((BufferedReader reader) -> extractItemsBetweenCourses(reader, start, end))
                .orElse(new ArrayList<>());
    }

    private static List<String> extractItemsBetweenCourses(BufferedReader reader, String start, String end) {
        List<String> result = new ArrayList<>();
        boolean isBetweenCourses = false;
        Predicate<String> isCourseHeader = line -> line.startsWith(start);
        Predicate<String> isLevelHeader = line -> line.startsWith(end);
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!isBetweenCourses && isCourseHeader.test(line)) {
                    isBetweenCourses = true;
                } else if (isBetweenCourses && isLevelHeader.test(line)) {
                    break;
                } else if (isBetweenCourses && !line.trim().isEmpty()) {
                    result.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
