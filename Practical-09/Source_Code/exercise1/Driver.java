package exercise1;

import java.util.ArrayList;
import java.util.List;

/**
 * Driver demonstrating race condition on shared counter and resolution via synchronization.
 *
 * @author Krupal Parmar (25CS057)
 */
public class Driver {
    private static final int THREAD_COUNT = 10;
    private static final int INCREMENTS_PER_THREAD = 10_000;
    private static final int EXPECTED_TOTAL = THREAD_COUNT * INCREMENTS_PER_THREAD;

    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("  Practical 09 - Exercise 1: Shared Counter Race Condition");
        System.out.println("  Student: Krupal Parmar | ID: 25CS057 | University: CHARUSAT (DEPSTAR)");
        System.out.println("======================================================================\n");

        Counter sharedCounter = new Counter();

        // --------------------------------------------------------------------
        // Phase 1: Unsynchronized Execution (Demonstrating Race Condition)
        // --------------------------------------------------------------------
        System.out.println("--- Phase 1: Unsynchronized Execution ---");
        System.out.printf("Spawning %d threads, each performing %,d unsynchronized increments...%n",
                THREAD_COUNT, INCREMENTS_PER_THREAD);
        System.out.printf("Expected Final Total: %,d%n", EXPECTED_TOTAL);

        long startUnsync = System.currentTimeMillis();
        List<Thread> unsyncThreads = new ArrayList<>();
        for (int i = 1; i <= THREAD_COUNT; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < INCREMENTS_PER_THREAD; j++) {
                    sharedCounter.incrementUnsynchronized();
                }
            }, "Unsync-Worker-" + i);
            unsyncThreads.add(t);
            t.start();
        }

        // Wait for all threads to terminate
        for (Thread t : unsyncThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        long durationUnsync = System.currentTimeMillis() - startUnsync;

        int actualUnsync = sharedCounter.getCount();
        int lostUpdates = EXPECTED_TOTAL - actualUnsync;
        System.out.println("All unsynchronized worker threads completed.");
        System.out.printf("Actual Final Count    : %,d%n", actualUnsync);
        System.out.printf("Lost Updates Shortfall: %,d (%.2f%% lost)%n",
                lostUpdates, ((double) lostUpdates / EXPECTED_TOTAL) * 100.0);
        System.out.printf("Result Status         : %s%n",
                actualUnsync < EXPECTED_TOTAL ? "FAIL (Race Condition Detected - Count too low!)" : "UNEXPECTED MATCH");
        System.out.printf("Execution Time        : %d ms%n%n", durationUnsync);

        // --------------------------------------------------------------------
        // Phase 2: Synchronized Execution (Thread-Safe Mutual Exclusion)
        // --------------------------------------------------------------------
        System.out.println("--- Phase 2: Synchronized Execution ---");
        sharedCounter.reset();
        System.out.printf("Counter reset to %d.%n", sharedCounter.getCount());
        System.out.printf("Spawning %d threads, each performing %,d synchronized increments...%n",
                THREAD_COUNT, INCREMENTS_PER_THREAD);
        System.out.printf("Expected Final Total: %,d%n", EXPECTED_TOTAL);

        long startSync = System.currentTimeMillis();
        List<Thread> syncThreads = new ArrayList<>();
        for (int i = 1; i <= THREAD_COUNT; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < INCREMENTS_PER_THREAD; j++) {
                    sharedCounter.incrementSynchronized();
                }
            }, "Sync-Worker-" + i);
            syncThreads.add(t);
            t.start();
        }

        for (Thread t : syncThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        long durationSync = System.currentTimeMillis() - startSync;

        int actualSync = sharedCounter.getCount();
        System.out.println("All synchronized worker threads completed.");
        System.out.printf("Actual Final Count    : %,d%n", actualSync);
        System.out.printf("Lost Updates Shortfall: %,d%n", EXPECTED_TOTAL - actualSync);
        System.out.printf("Result Status         : %s%n",
                actualSync == EXPECTED_TOTAL ? "SUCCESS (100% Accurate - Synchronized Mutual Exclusion Verified)" : "FAIL");
        System.out.printf("Execution Time        : %d ms%n", durationSync);
        System.out.println("======================================================================");
    }
}

