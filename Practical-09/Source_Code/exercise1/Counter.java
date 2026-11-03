package exercise1;

/**
 * Shared counter demonstrating race conditions and synchronized thread safety.
 *
 * @author Krupal Parmar (25CS057)
 */
public class Counter {
    private int count = 0;

    /**
     * Unsynchronized increment.
     * The non-atomic operation (read-modify-write: load, add, store)
     * allows interleaving between concurrent threads, leading to lost updates.
     */
    public void incrementUnsynchronized() {
        count++;
    }

    /**
     * Synchronized increment.
     * Acquires intrinsic lock on 'this' instance, ensuring atomic mutual exclusion.
     */
    public synchronized void incrementSynchronized() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public void reset() {
        count = 0;
    }
}

