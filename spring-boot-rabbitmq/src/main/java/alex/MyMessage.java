package alex;

import java.util.StringJoiner;

/**
 * MyMessage.
 */
public class MyMessage {

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MyMessage.class.getSimpleName() + "[", "]")
            .add("id='" + id + "'")
            .add("name='" + name + "'")
            .toString();
    }
}
