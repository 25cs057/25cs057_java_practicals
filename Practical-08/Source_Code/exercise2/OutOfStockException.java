package exercise2;

/**
 * Custom checked exception thrown when an inventory shortfall occurs.
 * Carries the specific shortfall quantity and item name.
 */
public class OutOfStockException extends Exception {
    private final String item;
    private final int shortfall;

    public OutOfStockException(String item, int shortfall) {
        super(String.format("Out of Stock: Request for '%s' exceeds available stock by %d units.", item, shortfall));
        this.item = item;
        this.shortfall = shortfall;
    }

    public String getItem() {
        return item;
    }

    public int getShortfall() {
        return shortfall;
    }
}

