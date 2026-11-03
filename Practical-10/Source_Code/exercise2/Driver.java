package exercise2;

import java.util.List;

/**
 * Driver coordinating Producer and Consumer threads with a bounded buffer using wait() and notify().
 *
 * @author Krupal Parmar (25CS057)
 */
public class Driver {
    private static final int BUFFER_CAPACITY = 3;
    private static final int TOTAL_ITEMS = 10;

    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("  Practical 10 - Exercise 2: Producer-Consumer with wait()/notifyAll()");
        System.out.println("  Student: Krupal Parmar | ID: 25CS057 | University: CHARUSAT (DEPSTAR)");
        System.out.println("======================================================================\n");

        System.out.printf("Initializing Shared Bounded Buffer (Capacity: %d items)%n", BUFFER_CAPACITY);
        System.out.printf("Total Items to Exchange: %d (in sequential FIFO order)%n%n", TOTAL_ITEMS);

        SharedBuffer sharedBuffer = new SharedBuffer(BUFFER_CAPACITY);
        Producer producerTask = new Producer(sharedBuffer, TOTAL_ITEMS);
        Consumer consumerTask = new Consumer(sharedBuffer, TOTAL_ITEMS);

        Thread producerThread = new Thread(producerTask, "Producer-Thread");
        Thread consumerThread = new Thread(consumerTask, "Consumer-Thread");

        long startTime = System.currentTimeMillis();

        System.out.println("Starting Producer and Consumer threads...\n");
        producerThread.start();
        consumerThread.start();

        // Wait for both threads to finish
        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted while waiting for workers!");
            Thread.currentThread().interrupt();
        }

        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("\n----------------------------------------------------------------------");
        System.out.println("  Execution & Data Integrity Verification Summary");
        System.out.println("----------------------------------------------------------------------");

        List<Integer> produced = producerTask.getProducedItems();
        List<Integer> consumed = consumerTask.getConsumedItems();

        System.out.println("  Produced Items List : " + produced);
        System.out.println("  Consumed Items List : " + consumed);
        System.out.printf("  Final Buffer Size   : %d items remaining%n", sharedBuffer.size());
        System.out.printf("  Elapsed Time        : %d ms%n", elapsedTime);

        boolean exactMatch = produced.equals(consumed) && produced.size() == TOTAL_ITEMS;
        System.out.println("----------------------------------------------------------------------");
        System.out.printf("  Verification Status : %s%n",
                exactMatch
                        ? "SUCCESS (All 10 items produced and consumed in exact order with NONE lost!)"
                        : "FAIL (Mismatch or data loss detected!)");
        System.out.println("======================================================================");
    }
}

