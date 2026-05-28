package fundamentals;

public interface BaseInterface {
    default void sayHello() {
        System.out.println("Hello from BaseInterface!");
    }

    static void sayGoodbye() {
        System.out.println("Goodbye from BaseInterface!");
    }
}
