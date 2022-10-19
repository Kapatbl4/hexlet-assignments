package exercise;


import java.util.stream.Collectors;
import java.util.stream.Stream;

// BEGIN
class App {
    public static String getForwardedVariables(String source) {
        return source.lines()
                .filter(s -> s.startsWith("environment"))
                .map(s -> s.replaceAll("environment=\"", ""))
                .map(s -> s.replaceAll("\"", ""))
                .flatMap(s -> Stream.of(s.split(",")))
                .filter(s -> s.startsWith("X_FORWARDED_"))
                .map(s -> s.replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}
//END
