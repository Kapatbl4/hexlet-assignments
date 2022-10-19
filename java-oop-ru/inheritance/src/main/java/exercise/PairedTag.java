package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String name;
    private String body;
    private List<Tag> children;

    public PairedTag(String name, Map<String, String> attributes, String body, List<Tag> children) {
        super(name, attributes);
        this.name = name;
        this.body = body;
        this.children = children;
    }

    public String toString() {
        String childrenString = children.stream().map(Tag::toString).collect(Collectors.joining());
        return super.toString() + body + childrenString + "</" + name + ">";
    }
}
// END
