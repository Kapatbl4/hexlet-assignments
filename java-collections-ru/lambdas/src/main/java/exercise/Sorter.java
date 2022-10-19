package exercise;

import java.time.Instant;
import java.util.*;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// BEGIN
class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> list) {
        return list.stream()
                .filter(s -> s.get("gender").equals("male"))
                .sorted(Comparator.comparing(x -> LocalDate.parse(x.get("birthday"))))
                .map(s -> s.get("name"))
                .collect(Collectors.toList());
    }
}
// END
