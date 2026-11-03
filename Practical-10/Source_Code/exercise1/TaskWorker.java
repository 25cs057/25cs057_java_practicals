package exercise1;

/**
 * Runnable worker task that simulates bounded execution workload.
 *
 * @author Krupal Parmar (25CS057)
 */
public class TaskWorker implements Runnable {
    private final int taskId;
    private final int executionTimeMs;

    public TaskWorker(int taskId, int executionTimeMs) {
        this.taskId = taskId;
        this.executionTimeMs = executionTimeMs;
    }

    public int getTaskId() {
        return taskId;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.printf("  [START] Task #%02d assigned to %-20s (Duration: %d ms)%n",
                taskId, threadName, executionTimeMs);
        try {
            Thread.sleep(executionTimeMs);
        } catch (InterruptedException e) {
            System.err.printf("  [INTERRUPT] Task #%02d interrupted on %s%n", taskId, threadName);
            Thread.currentThread().interrupt();
        }
        System.out.printf("  [DONE ] Task #%02d completed by %-20s%n", taskId, threadName);
    }
}

