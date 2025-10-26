import java.util.*;

public class Parent {
    private int count = 4;
    private static int value = 5;

    private static class Child {
        private int counter = 60;
        private static int val = 99;

        public void print() {
            System.out.println("Counter: " + counter + " val: "+ val + " value: " + value);

            // cannot access non-static memeber from parent class
            // System.out.println("Count: " + count);
        }
    };

    public void childPrint() {
        new Child().print();
    }
};