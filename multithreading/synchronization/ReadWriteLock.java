//package multithreading.synchronization;
//
//import java.util.concurrent.locks.ReadWriteLock;
//import java.util.concurrent.locks.ReentrantReadWriteLock;
//
//class Counter {
//
//    private int count = 0;
//
//    // Create ReadWriteLock
//    private final ReadWriteLock lock = new ReentrantReadWriteLock();
//
//    // WRITE LOCK
//    public void increment() {
//
//        lock.writeLock().lock();
//
//        try {
//            count++;
//            System.out.println(Thread.currentThread().getName()
//                    + " incremented count to " + count);
//
//        } finally {
//            lock.writeLock().unlock();
//        }
//    }
//
//    // READ LOCK
//    public int getCount() {
//
//        lock.readLock().lock();
//
//        try {
//            System.out.println(Thread.currentThread().getName()
//                    + " reading count: " + count);
//
//            return count;
//
//        } finally {
//            lock.readLock().unlock();
//        }
//    }
//}
//
//public class ReadWriteLockExample {
//
//    public static void main(String[] args) {
//
//        Counter counter = new Counter();
//
//        // Writer thread
//        Thread writer = new Thread(() -> {
//
//            for(int i = 0; i < 5; i++) {
//
//                counter.increment();
//
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }, "Writer");
//
//        // Reader threads
//        Runnable readerTask = () -> {
//
//            for(int i = 0; i < 5; i++) {
//
//                counter.getCount();
//
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//
//        Thread reader1 = new Thread(readerTask, "Reader-1");
//        Thread reader2 = new Thread(readerTask, "Reader-2");
//
//        writer.start();
//        reader1.start();
//        reader2.start();
//    }
//}