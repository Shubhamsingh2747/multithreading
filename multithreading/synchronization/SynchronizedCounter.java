package multithreading.synchronization;

public class SynchronizedCounter extends Thread {

    static int counter = 0;

    static synchronized void increment() { //critical section - only one thread can execute this method at a time, if one thread is executing this method, other threads will be blocked until the first thread finishes executing this method
                                           //intrinsic lock - every object in Java has an intrinsic lock, when a thread acquires the lock, it can execute the synchronized method, when it finishes executing the method, it releases the lock, other threads can acquire the lock and execute the method
        counter++;                         //explicit lock is needed here as if the operation takes long time to execute, it will block other threads for a long time, so we can use explicit lock to allow other threads to execute the method while one thread is executing the critical section, but in this case, we are using intrinsic lock which is simpler to use and sufficient for this example
    }

    @Override
    public void run() {
        for(int i = 0; i < 10000; i++) {
            increment();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        SynchronizedCounter t1 = new SynchronizedCounter();
        SynchronizedCounter t2 = new SynchronizedCounter();

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter);
    }
}

//synchronized disadvantages - it can lead to deadlock if not used carefully, it can lead to starvation if one thread is constantly acquiring the lock,
// it can lead to performance issues if the critical section is too long or if there are too many threads trying to acquire the lock,
// it can lead to thread contention if there are too many threads trying to acquire the lock at the same time,
// no interruptions allowed - if a thread is waiting to acquire a lock, it cannot be interrupted, it will wait indefinitely until it acquires the lock, which can lead to issues if the thread is waiting for a long time or if the thread is waiting for a lock that is held by another thread that is waiting for a lock held by the first thread, leading to a deadlock.