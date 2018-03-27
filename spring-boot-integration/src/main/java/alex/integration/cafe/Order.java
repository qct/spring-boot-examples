package alex.integration.cafe;

import java.util.ArrayList;
import java.util.List;

/**
 * default description.
 *
 * @author qct
 * @since 1.0
 */
public class Order {

    private List<OrderItem> orderItems = new ArrayList<OrderItem>();

    private int number;

    public Order(int number) {
        this.number = number;
    }

    public void addItem(DrinkType drinkType, int shots, boolean iced) {
        this.orderItems.add(new OrderItem(this, drinkType, shots, iced));
    }

    public int getNumber() {
        return number;
    }

    public List<OrderItem> getItems() {
        return this.orderItems;
    }

    @Override
    public String toString() {
        return "Order number " + number;
    }
}
