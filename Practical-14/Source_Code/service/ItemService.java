package service;

import model.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Service layer managing inventory items backed by an ArrayList.
 * Enforces business logic and validation constraints.
 *
 * @author Krupal Parmar (25CS057)
 */
public class ItemService {
    private final List<Item> items = new ArrayList<>();

    /**
     * Adds an item to the repository.
     * Validates non-null entity, non-blank name, positive price, and non-duplicate ID.
     */
    public void addItem(Item item) throws InvalidItemException {
        if (item == null) {
            throw new InvalidItemException("Item cannot be null!");
        }
        if (item.getId() == null || item.getId().trim().isEmpty()) {
            throw new InvalidItemException("Item ID cannot be empty or blank!");
        }
        if (item.getName() == null || item.getName().trim().isEmpty()) {
            throw new InvalidItemException("Item name cannot be empty or blank!");
        }
        if (item.getPrice() <= 0.0) {
            throw new InvalidItemException("Item price must be strictly positive! Received: " + item.getPrice());
        }
        if (item.getQuantity() < 0) {
            throw new InvalidItemException("Item quantity cannot be negative! Received: " + item.getQuantity());
        }

        // Check duplicate ID
        for (Item existing : items) {
            if (existing.getId().equalsIgnoreCase(item.getId())) {
                throw new InvalidItemException("Item with ID '" + item.getId() + "' already exists!");
            }
        }

        items.add(item);
    }

    public List<Item> getAllItems() {
        return Collections.unmodifiableList(items);
    }

    public int getItemCount() {
        return items.size();
    }

    public Item findItemById(String id) throws InvalidItemException {
        if (id == null || id.trim().isEmpty()) {
            throw new InvalidItemException("Search ID cannot be empty!");
        }
        for (Item item : items) {
            if (item.getId().equalsIgnoreCase(id.trim())) {
                return item;
            }
        }
        throw new InvalidItemException("Item not found with ID: '" + id + "'");
    }

    public boolean removeItem(String id) throws InvalidItemException {
        Item item = findItemById(id);
        return items.remove(item);
    }

    public void clear() {
        items.clear();
    }
}

