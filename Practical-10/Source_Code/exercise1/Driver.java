package exercise1;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Driver demonstrating fixed thread pool execution, thread reuse, and controlled shutdown.
 *
 * @author Krupal Parmar (25CS057)
 */
public class Driver {
    private static final int POOL_SIZE = 3;
    private static final int TOTAL_TASKS = 10;

    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("  Practical 10 - Exercise 1: Thread-Pool Runner (ExecutorService)");
        System.out.println("  Student: Krupal Parmar | ID: 25CS057 | University: CHARUSAT (DEPSTAR)");
        System.out.println("======================================================================\n");

        System.out.printf("Creating Fixed Thread Pool with capacity: %d worker threads%n", POOL_SIZE);
        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);

        // Map to track task execution frequency per pool worker thread
        Map<String, AtomicInteger> threadTaskCount = new ConcurrentHashMap<>();

        System.out.printf("Submitting %,d tasks to thread pool queue...%n%n", TOTAL_TASKS);

        long startTime = System.currentTimeMillis();

        for (int i = 1; i <= TOTAL_TASKS; i++) {
            final int taskId = i;
            final int duration = 40 + (i * 10); // Varied execution duration
            executor.execute(() -> {
                String threadName = Thread.currentThread().getName();
                threadTaskCount.computeIfAbsent(threadName, k -> new AtomicInteger(0)).incrementAndGet();

                TaskWorker worker = new TaskWorker(taskId, duration);
                worker.run();
            });
        }

        // Initiate controlled pool shutdown
        System.out.println("\nAll tasks submitted. Invoking executor.shutdown()...");
        executor.shutdown();

        try {
            System.out.println("Awaiting task completion with awaitTermination(10, TimeUnit.SECONDS)...");
            boolean finished = executor.awaitTermination(10, TimeUnit.SECONDS);
            long totalElapsed = System.currentTimeMillis() - startTime;

            System.out.printf("%nAll tasks finished cleanly: %s (Total wall-clock time: %d ms)%n%n",
                    finished, totalElapsed);

            // Display thread recycling analytics
            System.out.println("----------------------------------------------------------------------");
            System.out.println("  Thread Pool Reuse Verification Summary");
            System.out.println("----------------------------------------------------------------------");
            System.out.printf("  Total Worker Threads Created: %d (Expected: %d)%n",
                    threadTaskCount.size(), POOL_SIZE);

            Map<String, AtomicInteger> sortedStats = new TreeMap<>(threadTaskCount);
            for (Map.Entry<String, AtomicInteger> entry : sortedStats.entrySet()) {
                System.out.printf("    - %-22s executed %d tasks%n", entry.getKey(), entry.getValue().get());
            }

            System.out.println("----------------------------------------------------------------------");
            System.out.printf("  Status: %s%n",
                    (threadTaskCount.size() <= POOL_SIZE)
                            ? "SUCCESS (Fixed pool reused exactly 3 worker threads across 10 tasks!)"
                            : "FAIL (Unexpected thread count spawned)");
            System.out.println("======================================================================");

        } catch (InterruptedException e) {
            System.err.println("Execution interrupted during awaitTermination!");
            Thread.currentThread().interrupt();
        }
    }
}

