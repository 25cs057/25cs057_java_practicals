package exercise2;

/**
 * Practical 08 - Exercise 2 (Driver)
 * Student Name: Krupal Parmar
 * Student ID: 25CS057
 * Course: CEUE203 - Object-Oriented Programming
 *
 * Problem Statement:
 * Stock issue: a Warehouse where issue(item, qty) throws a custom checked OutOfStockException
 * carrying the shortfall, and InvalidQuantityException for qty <= 0. Process a list of
 * requests, catching and reporting each failure without stopping the run.
 */
public class Driver {

    record IssueRequest(String item, int qty) {}

    public static void main(String[] args) {
        System.out.println("=== Practical 08 - Exercise 2: Warehouse Stock Issue System ===");

        Warehouse warehouse = new Warehouse();
        warehouse.addStock("Laptop", 10);
        warehouse.addStock("Keyboard", 15);
        warehouse.addStock("Monitor", 5);

        System.out.println("Initial Warehouse Inventory:");
        warehouse.getAllStock().forEach((item, qty) ->
                System.out.println("  * " + item + ": " + qty + " units"));

        // List of batch requests to test various scenarios
        IssueRequest[] batchRequests = new IssueRequest[] {
            new IssueRequest("Laptop", 6),       // Valid: 10 - 6 = 4 remaining
            new IssueRequest("Monitor", -2),     // Invalid: qty <= 0 -> InvalidQuantityException
            new IssueRequest("Laptop", 8),       // Out of Stock: only 4 left, requested 8 (shortfall: 4)
            new IssueRequest("Keyboard", 12),    // Valid: 15 - 12 = 3 remaining
            new IssueRequest("Printer", 4),      // Out of Stock: 0 left, requested 4 (shortfall: 4)
            new IssueRequest("Monitor", 0),      // Invalid: qty == 0 -> InvalidQuantityException
            new IssueRequest("Monitor", 3)       // Valid: 5 - 3 = 2 remaining
        };

        System.out.println("\nProcessing Batch Issue Requests (Non-terminating Error Handling):");

        for (int i = 0; i < batchRequests.length; i++) {
            IssueRequest req = batchRequests[i];
            System.out.printf("%n[Request #%d] Attempting to issue %d units of '%s':%n",
                    (i + 1), req.qty(), req.item());

            try {
                warehouse.issue(req.item(), req.qty());
            } catch (InvalidQuantityException e) {
                System.out.println("  [CAUGHT InvalidQuantityException] " + e.getMessage());
                System.out.println("  -> Error Detail: Invalid input value: " + e.getQuantity());
            } catch (OutOfStockException e) {
                System.out.println("  [CAUGHT OutOfStockException] " + e.getMessage());
                System.out.println("  -> Error Detail: Available shortfall = " + e.getShortfall() + " unit(s) for item '" + e.getItem() + "'");
            }
        }

        System.out.println("\n--- Final Warehouse Inventory Summary ---");
        warehouse.getAllStock().forEach((item, qty) ->
                System.out.println("  * " + item + ": " + qty + " units"));
    }
}

