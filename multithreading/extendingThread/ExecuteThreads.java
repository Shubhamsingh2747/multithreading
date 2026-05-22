package multithreading.extendingThread;

public class ExecuteThreads {

    public static void main(String[] args) throws InterruptedException {
        Multithreading multithreading = new Multithreading("Thread-t1");
        multithreading.setPriority(Thread.MAX_PRIORITY); //this is just to show that we can set priority of thread, but it doesn't mean that it will always execute first, it depends on the scheduler of the operating system
        System.out.println(multithreading.getState()); //NEW
        multithreading.start();
        System.out.println(multithreading.getState()); //RUNNABLE
        multithreading.join(); //even if thread is sleeping, multithreading class will wait until it finishes and then main thread will start executing
        System.out.println(multithreading.getState()); //TERMINATED
        for(int i=0; i<5; i++) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " is running with priority: " + Thread.currentThread().getPriority() + " counter: " + i);
        }
    }
}

//OTHER THREAD METHODS
//1. sleep() - it is a static method of Thread class, it is used to pause the execution of the current thread for a specified time. It throws InterruptedException if the thread is interrupted while sleeping.
//2. join() - it is a non-static method of Thread class, it is used to wait for a thread to die. It throws InterruptedException if the thread is interrupted while waiting.
//3. yield() - it is a static method of Thread class, it is used to pause the execution of the current thread and allow other threads to execute. It does not throw any exception. It is just a hint to the scheduler that the current thread is willing to yield its current use of a processor.
//4. interrupt() - it is a non-static method of Thread class, it is used to interrupt a thread. It does not throw any exception. It is just a way to signal a thread that it should stop what it is doing and do something else. It is up to the thread to decide how to respond to the interrupt signal.
//5. isAlive() - it is a non-static method of Thread class, it is used to check if a thread is alive or not. It returns true if the thread is alive, otherwise it returns false. A thread is considered alive if it has been started and has not yet died.
//6. getState() - it is a non-static method of Thread class, it is used to get the state of a thread. It returns an enum value of type Thread.State which can be NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, or TERMINATED.
//7. setPriority() - it is a non-static method of Thread class, it is used to set the priority of a thread. It takes an integer value between 1 and 10, where 1 is the lowest priority and 10 is the highest priority. The default priority is 5. The priority of a thread can affect the order in which threads are scheduled for execution, but it does not guarantee that higher priority threads will always execute before lower priority threads.
//8. DAEMON THREADS - A daemon thread is a thread that runs in the background and does not prevent the JVM from exiting when the program finishes. A daemon thread is typically used for tasks such as garbage collection, background monitoring, or other tasks that do not require user interaction. To create a daemon thread, you can call the setDaemon(true) method on a Thread object before starting it. Once a thread is marked as a daemon thread, it will automatically terminate when all non-daemon threads have finished executing.
//9. setDaemon() - it is a non-static method of Thread class, it is used to mark a thread as a daemon thread. It takes a boolean value, if true, the thread will be marked as a daemon thread, otherwise it will be marked as a user thread. A daemon thread is a thread that runs in the background and does not prevent the JVM from exiting when the program finishes. A daemon thread is typically used for tasks such as garbage collection, background monitoring, or other tasks that do not require user interaction. Once a thread is marked as a daemon thread, it will automatically terminate when all non-daemon threads have finished executing.