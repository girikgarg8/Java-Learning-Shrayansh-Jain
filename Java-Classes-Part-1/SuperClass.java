import java.util.*;

public class SuperClass {
    private int count = 0;
    private static int counter = 1;

    // non-static inner class
    public class InnerClass1 {
        public int val = 99;
        public static final int value = 100;
    };

    // non-static inner class which extends another inner class
    public class InnerClass2 extends InnerClass1 {
        public void print() {
            System.out.println("Val: " + val + " value: " + value + " Count:" + count + " Counter:" + counter);
        }
    };

    public static class InnerClass3 {
        public InnerClass3() {
            System.out.println("Inner class 3 object initializing");
        }
    };
};