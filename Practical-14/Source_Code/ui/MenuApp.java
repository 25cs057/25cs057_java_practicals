package ui;

import model.Item;
import service.InvalidItemException;
import service.ItemService;
import test.ItemServiceTest;
import test.TestRunner;

import java.util.List;
import java.util.Scanner;

/**
 * Presentation layer console menu driving the layered application.
 *
 * @author Krupal Parmar (25CS057)
 */
public class MenuApp {
    private final ItemService itemService = new ItemService();
    private final Scanner scanner;

    public MenuApp(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayMenu() {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("  INVENTORY MANAGEMENT SYSTEM (Layered Architecture)");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("  1. Add New Item");
        System.out.println("  2. List All Items");
        System.out.println("  3. Search Item by ID");
        System.out.println("  4. Remove Item by ID");
        System.out.println("  5. Display Total Items Count");
        System.out.println("  6. Run Automated Unit Test Suite (@Test)");
        System.out.println("  7. Exit Application");
        System.out.println("----------------------------------------------------------------------");
        System.out.print("Select an option (1-7): ");
    }

    public void run() {
        System.out.println("======================================================================");
        System.out.println("  Practical 14: Layered Architecture Application & Unit Testing");
        System.out.println("  Student: Krupal Parmar | ID: 25CS057 | University: CHARUSAT (DEPSTAR)");
        System.out.println("======================================================================\n");

        // Seed initial items
        try {
            itemService.addItem(new Item("ITM101", "Mechanical Keyboard", 3499.00, 15));
            itemService.addItem(new Item("ITM102", "Ergonomic Mouse",    1299.50, 40));
            itemService.addItem(new Item("ITM103", "4K Ultra-HD Monitor", 24999.00, 8));
            System.out.println("Pre-seeded 3 default inventory items into the Service layer.\n");
        } catch (InvalidItemException e) {
            System.err.println("Seeding error: " + e.getMessage());
        }

        boolean running = true;
        while (running && scanner.hasNextLine()) {
            displayMenu();
            String input = scanner.nextLine().trim();
            System.out.println(input); // Echo input for clarity in logs

            switch (input) {
                case "1" -> handleAddItem();
                case "2" -> handleListItems();
                case "3" -> handleSearchItem();
                case "4" -> handleRemoveItem();
                case "5" -> handleCount();
                case "6" -> TestRunner.runTests(ItemServiceTest.class);
                case "7" -> {
                    System.out.println("\nExiting application. Thank you!");
                    running = false;
                }
                default -> System.out.println("Invalid option! Please enter a number between 1 and 7.\n");
            }
        }
    }

    private void handleAddItem() {
        System.out.print("Enter Item ID (e.g. ITM104): ");
        String id = scanner.nextLine().trim();
        System.out.println(id);

        System.out.print("Enter Item Name: ");
        String name = scanner.nextLine().trim();
        System.out.println(name);

        System.out.print("Enter Item Price (INR): ");
        String priceStr = scanner.nextLine().trim();
        System.out.println(priceStr);

        System.out.print("Enter Stock Quantity: ");
        String qtyStr = scanner.nextLine().trim();
        System.out.println(qtyStr);

        try {
            double price = Double.parseDouble(priceStr);
            int qty = Integer.parseInt(qtyStr);
            Item item = new Item(id, name, price, qty);
            itemService.addItem(item);
            System.out.printf("SUCCESS: Item '%s' added successfully! Total items now: %d%n%n",
                    name, itemService.getItemCount());
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Price and Quantity must be valid numerical values!\n");
        } catch (InvalidItemException e) {
            System.out.println("VALIDATION ERROR: " + e.getMessage() + "\n");
        }
    }

    private void handleListItems() {
        List<Item> all = itemService.getAllItems();
        System.out.printf("%n--- Current Inventory Items (%d items registered) ---%n", all.size());
        if (all.isEmpty()) {
            System.out.println("  (Inventory is currently empty)");
        } else {
            for (int i = 0; i < all.size(); i++) {
                System.out.printf("  %2d. %s%n", (i + 1), all.get(i));
            }
        }
        System.out.println();
    }

    private void handleSearchItem() {
        System.out.print("Enter Item ID to search: ");
        String searchId = scanner.nextLine().trim();
        System.out.println(searchId);
        try {
            Item found = itemService.findItemById(searchId);
            System.out.println("FOUND: " + found + "\n");
        } catch (InvalidItemException e) {
            System.out.println("SEARCH FAILED: " + e.getMessage() + "\n");
        }
    }

    private void handleRemoveItem() {
        System.out.print("Enter Item ID to remove: ");
        String removeId = scanner.nextLine().trim();
        System.out.println(removeId);
        try {
            boolean removed = itemService.removeItem(removeId);
            if (removed) {
                System.out.printf("SUCCESS: Item '%s' removed. Remaining items: %d%n%n",
                        removeId, itemService.getItemCount());
            }
        } catch (InvalidItemException e) {
            System.out.println("REMOVE FAILED: " + e.getMessage() + "\n");
        }
    }

    private void handleCount() {
        System.out.printf("%nTOTAL COUNT: %d items currently registered in Service Layer.%n%n",
                itemService.getItemCount());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuApp app = new MenuApp(scanner);
        app.run();
    }
}

