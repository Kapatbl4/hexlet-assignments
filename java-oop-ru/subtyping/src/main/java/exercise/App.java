package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage keyValueStorage) {
        Set<Entry<String, String>> set = keyValueStorage.toMap().entrySet();
        for (Map.Entry<String, String> pair : set) {
            keyValueStorage.unset(pair.getKey());
        }
        for (Map.Entry<String, String> pair : set) {
            keyValueStorage.set(pair.getValue(), pair.getKey());
        }
    }
}
// END
