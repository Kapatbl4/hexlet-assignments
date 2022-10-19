package exercise;

import java.util.*;


// BEGIN
class App {
    public static Map<String, String> genDiff(Map<String, Object> source1, Map<String, Object> source2) {
        Map<String, String> result = new LinkedHashMap<>();
        Set<String> tree = new TreeSet<>();
        Collections.addAll(tree, source1.keySet().toArray(new String[0]));
        Collections.addAll(tree, source2.keySet().toArray(new String[0]));
        List<String> keys1 = Arrays.asList(source1.keySet().toArray(new String[0]));
        List<String> keys2 = Arrays.asList(source2.keySet().toArray(new String[0]));
        for (String s : tree) {
            if (!keys1.contains(s)) {
                result.put(s, "added");
            } else if (!keys2.contains(s)) {
                result.put(s, "deleted");
            } else if (source1.get(s).equals(source2.get(s))) {
                result.put(s, "unchanged");
            } else if (!source1.get(s).equals(source2.get(s))) {
                result.put(s, "changed");
            }
        }
        return result;
    }
}
//END
