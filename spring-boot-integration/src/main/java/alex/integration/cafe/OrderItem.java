package alex.integration.cafe;

/**
 * default description.
 *
 * @author qct
 * @since 1.0
 */
public class OrderItem {

    private final Order order;
    private DrinkType type;
    private int shots = 1;
    private boolean iced = false;

    public OrderItem(Order order, DrinkType type, int shots, boolean iced) {
        this.order = order;
        this.type = type;
        this.shots = shots;
        this.iced = iced;
    }

    public Order getOrder() {
        return this.order;
    }

    public boolean isIced() {
        return this.iced;
    }

    public int getShots() {
        return shots;
    }

    public DrinkType getDrinkType() {
        return this.type;
    }

    @Override
    public String toString() {
        return ((this.iced) ? "iced " : "hot ")
                + " order:"
                + this.order.getNumber()
                + " "
                + this.shots
                + " shot "
                + this.type;
    }
}
