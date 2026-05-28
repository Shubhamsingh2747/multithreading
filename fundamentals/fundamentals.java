package fundamentals;

public class  fundamentals implements BaseInterface{

    @Override
    public void sayHello() {
        System.out.println("Hello from fundamentals class!");
    }

    public static void sayGoodbye() {
        System.out.println("Goodbye from fundamentals class!");
    }

    public static void main(String[] args) {
        fundamentals fundamentals = new fundamentals();
        fundamentals.sayHello(); // Calling default method
        fundamentals.sayGoodbye();// Calling overridden method
        BaseInterface.sayGoodbye();// Calling static method
    }
}
