package exercise2;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private final Map<String, Integer> stock = new HashMap<>();

    public void addStock(String item, int qty) {
        stock.put(item, stock.getOrDefault(item, 0) + qty);
    }

    public int getStock(String item) {
        return stock.getOrDefault(item, 0);
    }

    public Map<String, Integer> getAllStock() {
        return new HashMap<>(stock);
    }

    /**
     * Issues stock for an item.
     * @throws InvalidQuantityException if qty <= 0
     * @throws OutOfStockException if current available stock is less than requested
     */
    public void issue(String item, int qty) throws OutOfStockException, InvalidQuantityException {
        if (qty <= 0) {
            throw new InvalidQuantityException(qty);
        }

        int current = stock.getOrDefault(item, 0);
        if (current < qty) {
            int shortfall = qty - current;
            throw new OutOfStockException(item, shortfall);
        }

        stock.put(item, current - qty);
        System.out.printf("  [SUCCESS] Issued %d units of '%s'. Remaining stock: %d%n", qty, item, stock.get(item));
    }
}

