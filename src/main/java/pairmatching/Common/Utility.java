package pairmatching.Common;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Utility {

    private Utility() {
    }

    public static int convertStringToInt(String str) {
        return Integer.parseInt(str);
    }

    private static final String resourcePath = "/";

    public static List<String> readFile(String fileName) {
        return getResourceAsStream(fileName)
                .map(stream -> new BufferedReader(new InputStreamReader(stream)))
                .map(reader -> reader.lines().collect(Collectors.toList()))
                .orElse(List.of());
    }

    public static List<String> readFileBetween(String fileName, String start, String end) {
        return getResourceAsStream(fileName)
                .map(inputStream -> new BufferedReader(new InputStreamReader(inputStream)))
                .map(reader -> findDataBetween(reader, start, end))
                .orElse(List.of());
    }

    private static Optional<InputStream> getResourceAsStream(String fileName) {
        String filePath = resourcePath + fileName;
        return Optional.ofNullable(Utility.class.getResourceAsStream(filePath));
    }

    private static List<String> findDataBetween(BufferedReader reader, String start, String end) {
        Predicate<String> isCourseHeader = line -> line.startsWith(start);
        Predicate<String> isLevelHeader = line -> line.startsWith(end);

        return reader.lines()
                .dropWhile(line -> !isCourseHeader.test(line)) 
                .skip(1) 
                .takeWhile(line -> !isLevelHeader.test(line)) 
                .filter(line -> !line.trim().isEmpty())
                .toList();
    }

}
