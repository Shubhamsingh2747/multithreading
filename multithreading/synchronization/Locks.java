package multithreading.synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locks extends Thread {

    static int counter = 0;

    // Shared lock object
    //lock belongs to the class, so all threads will use the same lock object to synchronize access to the counter variable, ensuring that only one thread can access the critical section at a time
    //it locks the object, not the method, so it allows more fine-grained control over the locking mechanism, it can be used to allow multiple threads to execute the critical section simultaneously, but it requires more code and is more complex to use than intrinsic lock
    static Lock lock = new ReentrantLock(true); // fair lock to ensure that threads acquire the lock in the order they requested it

    @Override
    public void run() {

        for (int i = 0; i < 10000; i++) {

            lock.lock(); // acquire lock

            try {
                counter++;
            } finally {
                lock.unlock(); // always release lock
            }
        }
    }

    public static void main(String[] args) {

        Locks t1 = new Locks();
        Locks t2 = new Locks();

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println(counter);
    }
}

//MULTI-THREADING TERMS
//1. Critical Section - a section of code that accesses a shared resource and can be executed by only one thread at a time. In the above example, the critical section is the increment() method, which increments the counter variable. If multiple threads execute this method simultaneously
//2. Intrinsic Lock - every object in Java has an intrinsic lock, when a thread acquires the lock, it can execute the synchronized method, when it finishes executing the method, it releases the lock, other threads can acquire the lock and execute the method. In the above example, we are using intrinsic lock by declaring the increment() method as synchronized.
//3. Explicit Lock - a lock that is created and managed by the programmer, it is used to provide more control over the locking mechanism, it can be used to allow multiple threads to execute the critical section simultaneously, but it requires more code and is more complex to use than intrinsic lock. In the above example, we are using explicit lock by creating a Lock object and using its lock() and unlock() methods to acquire and release the lock.
//4. Deadlock - a situation where two or more threads are blocked forever, waiting for each other to release the locks they need to proceed. In the above example, if we have two locks and two threads, and each thread acquires one lock and waits for the other lock, it can lead to a deadlock.
//5. Starvation - a situation where a thread is unable to gain access to a resource because other threads are constantly acquiring the resource before it can. In the above example, if we have multiple threads and one thread is constantly acquiring the lock, it can lead to starvation for other threads that are waiting for the lock.
//7. Race Condition - a situation where the behavior of a program depends on the relative timing of events, such as the order in which threads execute. In the above example, if we do not use locks to synchronize access to the counter variable, it can lead to a race condition where the final value of the counter variable is unpredictable and can be different each time we run the program. This is because multiple threads can access and modify the counter variable simultaneously, leading to inconsistent results.
//8. Deadlock conditions :
//   1. Mutual Exclusion - at least one resource must be held in a non-shareable mode, meaning that only one thread can access the resource at a time.
//   2. Hold and Wait - a thread must be holding at least one resource and waiting to acquire additional resources that are currently being held by other threads.
//   3. No Preemption - resources cannot be forcibly taken away from a thread holding them, they must be released voluntarily by the thread.
//   4. Circular Wait - a set of threads must be waiting for each other in a circular chain, where each thread is waiting for a resource that is held by the next thread in the chain. For example, Thread A is waiting for a resource held by Thread B, Thread B is waiting for a resource held by Thread C, and Thread C is waiting for a resource held by Thread A, creating a circular wait condition.