package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    Map<String, String> map;
    public InMemoryKV(Map<String, String> map) {
        this.map = new HashMap<>(map);
    }
    @Override
    public void set(String key, String value) {
        map.put(key, value);
    }

    @Override
    public void unset(String key) {
        map.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        return defaultValue;
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(this.map);
    }
}
// END
