package multithreading.deadlock;

public class Counter2 {
    int counter = 0;

    public synchronized void increment(Counter1 c1) {
        counter++;

        // Thread-2 will hold Counter2 lock
        // and try to get Counter1 lock
        c1.incrementOnly();
    }

    public synchronized void incrementOnly() {
        counter++;
    }
}
