@FunctionalInterface
public interface Bird {
    public void fly();

    public default void hello() {
        System.out.println("Saying hello");
    }

    public static void eat() {
        System.out.println("Eating");
    }

    public String toString(); // object class method, this is not abstract
};