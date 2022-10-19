package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private String path;
    private Map<String, String> map;

    public FileKV(String path, Map<String, String> map) {
        this.path = path;
        this.map = new HashMap<>(map);
        Utils.writeFile(path, Utils.serialize(this.map));
    }

    @Override
    public void set(String key, String value) {
        this.map = Utils.unserialize(Utils.readFile(this.path));
        this.map.put(key, value);
        Utils.writeFile(this.path, Utils.serialize(this.map));
    }

    @Override
    public void unset(String key) {
        this.map = Utils.unserialize(Utils.readFile(this.path));
        this.map.remove(key);
        Utils.writeFile(this.path, Utils.serialize(this.map));
    }

    @Override
    public String get(String key, String defaultValue) {
        this.map = Utils.unserialize(Utils.readFile(this.path));
        return this.map.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(Utils.unserialize(Utils.readFile(this.path)));
    }
}
// END
