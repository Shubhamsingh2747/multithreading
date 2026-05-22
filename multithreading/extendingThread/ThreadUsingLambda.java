package multithreading.extendingThread;

public class ThreadUsingLambda {
    public static void main(String[] args) throws InterruptedException {
    Runnable thread1 = () -> {
        for(int i=0; i<5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " is running with priority: " + Thread.currentThread().getPriority() + " counter: " + i);
        }
    };
    Thread t1 = new Thread(thread1, "Thread-1");
    t1.start();
    for(int i=0; i<5; i++) {
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " is running with priority: " + Thread.currentThread().getPriority() + " counter: " + i);
    }
}
}
