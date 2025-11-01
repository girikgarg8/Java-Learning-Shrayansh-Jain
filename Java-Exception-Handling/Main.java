import java.util.*;

public class Main {
    public static void main(String [] args) {
//        method1();
        try {
            method3();
        }
        catch (MyCustomException ex) {
            System.out.println("Got exception: " + ex);
        }
    }

    public static void method2() {
        throw new RuntimeException("Hello");
    }

    public static void method1() {
        method2();
    }

    public static void method3() throws MyCustomException {
        throw new MyCustomException("Hi");
    }
}
