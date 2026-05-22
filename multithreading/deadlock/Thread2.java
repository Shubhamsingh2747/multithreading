package multithreading.deadlock;

public class Thread2 extends Thread{
    private Counter1 c1;
    private Counter2 c2;

    Thread2(Counter1 c1, Counter2 c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public void run() {

        for (int i = 0; i < 1000; i++) {
            c2.increment(c1);
        }
    }
}
