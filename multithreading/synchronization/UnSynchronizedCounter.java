package multithreading.synchronization;

public class UnSynchronizedCounter extends Thread{
    static int counter = 0;
    @Override
    public void run(){
        for(int i=0; i<10000; i++){
            counter++;
        }
    }

    public static void main(String[] args) {

        UnSynchronizedCounter t1 = new UnSynchronizedCounter();
        UnSynchronizedCounter t2 = new UnSynchronizedCounter();
        t1.start();
        t2.start();
        try{
            t1.join(); //join only ensures that main thread is waiting for t1 to finish, but it doesn't guarantee that t2 will finish before t1, so we need to call join on both threads to ensure that both threads have finished before we print the counter value
            t2.join(); //using join here because the last print statement has to be executed once  both threads are terminated and only main thread remains
        }catch (InterruptedException e){
            System.out.println(e);
        }
        System.out.println(counter);
    }
}
