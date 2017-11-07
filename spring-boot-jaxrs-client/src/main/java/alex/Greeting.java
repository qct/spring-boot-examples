package alex;

/**
 * <p>Created by qct on 2017/11/6.
 */
public class Greeting {

    private String message;

    public Greeting() {
    }

    public Greeting(String world) {
        this.message = world;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Greeting{" +
            "message='" + message + '\'' +
            '}';
    }
}
