package exercise;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildAppartmentsList(List<Home> list, int elementsCount) {
        List<String> result = list.stream().
                sorted(Comparator.comparing(Home::getArea)).
                limit(elementsCount).
                map(Home::toString).
                collect(Collectors.toList());
        return result;
    }
}
// END
