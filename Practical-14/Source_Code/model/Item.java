package model;

import java.io.Serializable;

/**
 * Domain model entity representing an inventory item.
 *
 * @author Krupal Parmar (25CS057)
 */
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String id;
    private final String name;
    private final double price;
    private final int quantity;

    public Item(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return String.format("Item [ID=%-6s | Name=%-18s | Price=INR %8.2f | Qty=%3d]",
                id, name, price, quantity);
    }
}

