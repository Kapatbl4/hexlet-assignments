package exercise;


import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
class App {
    public static String[][] enlargeArrayImage(String[][] image) {
        return Arrays.stream(image)
                .map(strings -> Arrays
                        .stream(strings)
                        .flatMap(s -> Stream.of(s, s))
                        .toArray(String[]::new))
                .flatMap(strings -> Stream.of(strings, strings))
                .toArray(String[][]::new);

    }
}
// END
