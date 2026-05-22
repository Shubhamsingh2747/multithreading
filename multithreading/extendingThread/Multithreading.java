package multithreading.extendingThread;

public class Multithreading extends Thread{
    Multithreading(String name){
        super(name);
    }
    @Override
    public void run() {
        for(int i=0; i<5; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " is running with priority: " + Thread.currentThread().getPriority() + " counter: " + i);
        }
    }

}
