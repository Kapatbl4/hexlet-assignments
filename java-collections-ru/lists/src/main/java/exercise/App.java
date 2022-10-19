package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String chars, String word) {
        List<Character> source = new ArrayList<>();
        for (char c : chars.toLowerCase().toCharArray()) {
            source.add(c);
        }

        List<Character> result = new ArrayList<>();
        for (char c : word.toLowerCase().toCharArray()) {
            result.add(c);
        }

        List<Character> check = new ArrayList<>();
        for (Character c : result) {
            if (source.remove(c)) {
                check.add(c);
            }
        }

        return result.size() == check.size();
    }
}

//END
