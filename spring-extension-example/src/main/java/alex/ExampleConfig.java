package alex;

/**
 * default description.
 *
 * @author qct
 * @date 2018/3/20
 * @since 1.0
 */
public class ExampleConfig {

    private String name;
    private int order;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "ExampleConfig{" + "name='" + name + '\'' + ", order=" + order + '}';
    }
}
