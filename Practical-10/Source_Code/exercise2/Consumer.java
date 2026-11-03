package exercise2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Consumer worker removing and processing sequential items from shared buffer.
 *
 * @author Krupal Parmar (25CS057)
 */
public class Consumer implements Runnable {
    private final SharedBuffer buffer;
    private final int totalItems;
    private final List<Integer> consumedItems = new ArrayList<>();

    public Consumer(SharedBuffer buffer, int totalItems) {
        this.buffer = buffer;
        this.totalItems = totalItems;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= totalItems; i++) {
                int item = buffer.consume();
                consumedItems.add(item);
                // Slight delay simulating consumption workload
                Thread.sleep(45);
            }
            System.out.println("  [CONSUMER FINISHED] All " + totalItems + " items consumed.");
        } catch (InterruptedException e) {
            System.err.println("  [CONSUMER ERROR] Interrupted during consumption!");
            Thread.currentThread().interrupt();
        }
    }

    public List<Integer> getConsumedItems() {
        return Collections.unmodifiableList(consumedItems);
    }
}

