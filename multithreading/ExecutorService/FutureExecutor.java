package multithreading.ExecutorService;

import java.util.concurrent.*;

public class FutureExecutor {
    public static void main(String[] args) {

        // Create a thread pool with 2 threads
        ExecutorService executor =
                Executors.newFixedThreadPool(5);

        // Submit a task that returns a result
        Future<Integer> futureResult = executor.submit(() -> {
            Thread.sleep(2000); // Simulate long-running task
            return 42; // Return some result
        });

        try {
            // Do some other work while the task is running
            System.out.println("Doing other work...");

            // Get the result of the task (this will block until the result is available)
            Integer result = futureResult.get();
            System.out.println("Result from future: " + result);
            System.out.println("last line of main method");
        } catch (InterruptedException |
                 ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }
}
