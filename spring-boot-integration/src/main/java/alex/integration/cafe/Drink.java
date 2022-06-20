package alex.integration.cafe;

/**
 * default description.
 *
 * @author qct
 * @since 1.0
 */
public class Drink {

    private boolean iced;

    private int shots;

    private DrinkType drinkType;

    private int orderNumber;

    public Drink(int orderNumber, DrinkType drinkType, boolean hot, int shots) {
        this.orderNumber = orderNumber;
        this.drinkType = drinkType;
        this.iced = hot;
        this.shots = shots;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    @Override
    public String toString() {
        return (iced ? "Iced" : "Hot") + " " + drinkType.toString() + ", " + shots + " shots.";
    }
}
