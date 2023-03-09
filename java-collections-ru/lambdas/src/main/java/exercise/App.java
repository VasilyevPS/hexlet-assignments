package exercise;

import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
public class App {
    public static String[][] enlargeArrayImage(String[][] image) {
        return Arrays.stream(image)
                .map(row -> Arrays.stream(row)
                    .flatMap(element -> Stream.of(element, element))
                    .toArray(String[]::new))
                .flatMap(row -> Stream.of(row, row))
                .toArray(String[][]::new);
    }
}
// END
