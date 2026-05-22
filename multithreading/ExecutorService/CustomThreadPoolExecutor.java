package multithreading.ExecutorService;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomThreadPoolExecutor {

    public static void main(String[] args) {

        // Custom Thread Factory
        ThreadFactory customFactory = new ThreadFactory() {

            private final AtomicInteger count = new AtomicInteger(1);

            @Override
            public Thread newThread(Runnable r) {

                Thread t = new Thread(r);

                t.setName("custom-thread-" + count.getAndIncrement());

                System.out.println("Creating new thread -> " + t.getName());

                return t;
            }
        };

        // Custom RejectedExecutionHandler
        RejectedExecutionHandler rejectionHandler =
                (r, executor) -> {
                    System.out.println(
                            "TASK REJECTED -> " + r.toString()
                    );
                };

        /*
            corePoolSize = 2
            maximumPoolSize = 4
            queue size = 2

            FLOW:

            1. First 2 tasks
               -> use core threads

            2. Next 2 tasks
               -> go into queue

            3. Next 2 tasks
               -> create extra threads till maxPoolSize

            4. Any further task
               -> REJECTED
         */

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,                         // corePoolSize
                4,                         // maximumPoolSize
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2), // queue capacity = 2
                customFactory,
                rejectionHandler
        );

        // Submit 8 tasks
        for (int i = 1; i <= 8; i++) {

            int taskId = i;

            executor.submit(() -> {

                System.out.println(
                        Thread.currentThread().getName()
                                + " STARTED Task-" + taskId
                );

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(
                        Thread.currentThread().getName()
                                + " FINISHED Task-" + taskId
                );

            });

            printExecutorState(executor, taskId);
        }

        executor.shutdown();
    }

    private static void printExecutorState(
            ThreadPoolExecutor executor,
            int taskNumber
    ) {

        System.out.println("\nAfter submitting Task-" + taskNumber);

        System.out.println(
                "Current Pool Size = "
                        + executor.getPoolSize()
        );

        System.out.println(
                "Active Threads = "
                        + executor.getActiveCount()
        );

        System.out.println(
                "Queue Size = "
                        + executor.getQueue().size()
        );

        System.out.println(
                "Completed Tasks = "
                        + executor.getCompletedTaskCount()
        );

        System.out.println("-----------------------------------");
    }
}