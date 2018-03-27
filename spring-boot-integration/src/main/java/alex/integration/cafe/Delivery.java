package alex.integration.cafe;

import java.util.List;

/**
 * default description.
 *
 * @author qct
 * @since 1.0
 */
public class Delivery {

    private static final String SEPARATOR = "-----------------------";


    private List<Drink> deliveredDrinks;

    private int orderNumber;


    public Delivery(List<Drink> deliveredDrinks) {
        assert (deliveredDrinks.size() > 0);
        this.deliveredDrinks = deliveredDrinks;
        this.orderNumber = deliveredDrinks.get(0).getOrderNumber();
    }


    public int getOrderNumber() {
        return orderNumber;
    }

    public List<Drink> getDeliveredDrinks() {
        return deliveredDrinks;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer(SEPARATOR + "\n");
        buffer.append("Order #" + getOrderNumber() + "\n");
        for (Drink drink : getDeliveredDrinks()) {
            buffer.append(drink);
            buffer.append("\n");
        }
        buffer.append(SEPARATOR + "\n");
        return buffer.toString();
    }
}
