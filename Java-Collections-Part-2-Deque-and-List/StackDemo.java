import java.util.*;

public class StackDemo {
    public static void main(String [] args) {
        // Stack extends the Vector concrete class. Since Vector is thread safe by nature, Stack is thread-safe too.

        Stack <Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);

        System.out.println(stack.pop());
    }
};