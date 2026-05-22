package multithreading.deadlock;

import java.util.PrimitiveIterator;

public class Counter1 {
    int counter = 0;

    public synchronized void increment(Counter2 c2) {
        counter++;

        // Thread-1 will hold Counter1 lock
        // and try to get Counter2 lock
        c2.incrementOnly();
    }

    public synchronized void incrementOnly() {
        counter++;
    }
}
