import java.util.*;

public class Outer {
    private int count = 5;
    private static int counter = 99;

    // non-static nested class
    public class Inner {
        private int val = 10;
        private static final int value = 11;

        public void print() {
            System.out.println("Val: " + val + " Value: " + value + " counter: " + counter);

            // Also has access to non-static data memeber of outer class
            System.out.println("Count: " + count);
        }
    };
};