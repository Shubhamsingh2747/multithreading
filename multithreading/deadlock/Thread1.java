package multithreading.deadlock;

public class Thread1 extends Thread{
    private Counter1 c1;
    private Counter2 c2;

    Thread1(Counter1 c1, Counter2 c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public void run() {

        for (int i = 0; i < 1000; i++) {
            c1.increment(c2);
        }
    }
}
