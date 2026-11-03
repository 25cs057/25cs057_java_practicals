package exercise2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Thread-safe bounded buffer coordinated with wait() and notifyAll().
 *
 * @author Krupal Parmar (25CS057)
 */
public class SharedBuffer {
    private final int capacity;
    private final Queue<Integer> queue = new LinkedList<>();

    public SharedBuffer(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Buffer capacity must be strictly positive!");
        }
        this.capacity = capacity;
    }

    /**
     * Inserts an item into the buffer.
     * Blocks if the buffer is full until space becomes available.
     */
    public synchronized void produce(int item) throws InterruptedException {
        while (queue.size() == capacity) {
            System.out.printf("  [WAIT-P] Buffer FULL (%d/%d). Producer thread waiting for consumer...%n",
                    queue.size(), capacity);
            wait();
        }

        queue.add(item);
        System.out.printf("  [PRODUCED] Item #%02d inserted.  Buffer occupancy: [%d/%d]%n",
                item, queue.size(), capacity);

        // Notify consumer waiting for data
        notifyAll();
    }

    /**
     * Extracts an item from the buffer.
     * Blocks if the buffer is empty until an item is produced.
     */
    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.printf("  [WAIT-C] Buffer EMPTY (0/%d). Consumer thread waiting for producer...%n",
                    capacity);
            wait();
        }

        int item = queue.poll();
        System.out.printf("  [CONSUMED] Item #%02d extracted. Buffer occupancy: [%d/%d]%n",
                item, queue.size(), capacity);

        // Notify producer waiting for buffer space
        notifyAll();
        return item;
    }

    public int getCapacity() {
        return capacity;
    }

    public synchronized int size() {
        return queue.size();
    }
}

