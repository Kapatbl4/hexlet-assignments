package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2));
        Assertions.assertArrayEquals(List.of(expected).toArray(), List.of(App.take(numbers1, 2)).toArray());

        List<Integer> numbers2 = new ArrayList<>(Arrays.asList(1, 34, 56, 23, 15, 54, 77, 95));
        List<Integer> expected2 = new ArrayList<>(Arrays.asList(1, 34, 56, 23, 15));
        Assertions.assertArrayEquals(List.of(expected2).toArray(), List.of(App.take(numbers2, 5)).toArray());

        List<Integer> numbers3 = new ArrayList<>(Arrays.asList(2, 3, 4, 10));
        List<Integer> expected3 = new ArrayList<>(Arrays.asList(2, 3, 4, 10));
        Assertions.assertArrayEquals(List.of(expected3).toArray(), List.of(App.take(numbers3, 8)).toArray());
        // END
    }
}
