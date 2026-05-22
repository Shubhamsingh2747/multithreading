package multithreading.deadlock;

public class DeadlockExample {
    public static void main(String[] args) {

        Counter1 c1 = new Counter1();
        Counter2 c2 = new Counter2();

        Thread1 t1 = new Thread1(c1, c2);
        Thread2 t2 = new Thread2(c1, c2);

        t1.start();
        t2.start();
    }
}
