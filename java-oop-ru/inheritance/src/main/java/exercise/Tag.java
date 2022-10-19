package exercise;


import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    private String name;
    private Map<String, String> attributes;

    public String toString() {
        String map = this.attributes.keySet().stream().map(key -> String.format(" %s=\"%s\"", key, attributes.get(key)))
                .collect(Collectors.joining());
        return "<" + this.name + map + ">";
    }

    public Tag(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    public Tag() {}

}
// END
