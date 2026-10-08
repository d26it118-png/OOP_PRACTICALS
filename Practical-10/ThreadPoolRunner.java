import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolRunner {
    public static void main(String[] args) {

        // Create a fixed thread pool of 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit 10 tasks
        for (int i = 1; i <= 10; i++) {
            final int id = i;

            executor.submit(() -> {
                System.out.println("Task " + id + " is running by "
                        + Thread.currentThread().getName());

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                System.out.println("Task " + id + " completed by "
                        + Thread.currentThread().getName());
            });
        }

        // Stop accepting new tasks
        executor.shutdown();

        try {
            // Wait until all tasks are completed
            if (executor.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("All tasks completed.");
            } else {
                System.out.println("Timeout occurred.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}