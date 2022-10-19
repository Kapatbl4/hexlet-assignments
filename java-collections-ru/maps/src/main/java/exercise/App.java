package exercise;

import java.util.*;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> map = new HashMap<>();
        if (sentence.isBlank()) return map;
        String[] words = sentence.split(" ");
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        return map;
    }

    public static String toString(Map<String, Integer> map) {
        StringBuilder result = new StringBuilder("{");
        if (map.isEmpty()) {
            result.append("}");
            return String.valueOf(result);
        }
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            result.append("\n").append("  ").append(pair.getKey()).append(": ").append(pair.getValue());
        }
        result.append("\n}");
        return String.valueOf(result);
    }
}
//END
