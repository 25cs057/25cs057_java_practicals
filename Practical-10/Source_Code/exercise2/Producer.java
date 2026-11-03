package exercise2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Producer worker producing sequential integer tokens into a shared buffer.
 *
 * @author Krupal Parmar (25CS057)
 */
public class Producer implements Runnable {
    private final SharedBuffer buffer;
    private final int totalItems;
    private final List<Integer> producedItems = new ArrayList<>();

    public Producer(SharedBuffer buffer, int totalItems) {
        this.buffer = buffer;
        this.totalItems = totalItems;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= totalItems; i++) {
                buffer.produce(i);
                producedItems.add(i);
                // Slight delay simulating generation time
                Thread.sleep(25);
            }
            System.out.println("  [PRODUCER FINISHED] All " + totalItems + " items produced.");
        } catch (InterruptedException e) {
            System.err.println("  [PRODUCER ERROR] Interrupted during production!");
            Thread.currentThread().interrupt();
        }
    }

    public List<Integer> getProducedItems() {
        return Collections.unmodifiableList(producedItems);
    }
}

