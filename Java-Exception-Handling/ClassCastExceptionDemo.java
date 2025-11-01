import java.util.*;

public class ClassCastExceptionDemo {
    public static void main(String [] args) {
        Object text = "abc";
        System.out.println((Integer) text);
    }
}
