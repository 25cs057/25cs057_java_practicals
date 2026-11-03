package exercise2;

/**
 * Custom checked exception thrown when requested quantity is non-positive (<= 0).
 */
public class InvalidQuantityException extends Exception {
    private final int quantity;

    public InvalidQuantityException(int quantity) {
        super(String.format("Invalid Quantity: Requested quantity %d must be strictly positive (> 0).", quantity));
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}

