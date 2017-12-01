package alex;

/**
 * <p>Created by damon.q on 2017/11/29.
 */
public class MyBean {

    private String name;

    public MyBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyBean{" +
            "name='" + name + '\'' +
            '}';
    }
}
