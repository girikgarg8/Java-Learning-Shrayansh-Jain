import java.sql.SQLException;
import java.util.*;

public class CheckedExceptionDemo {
    public static void main(String [] args) {
        try {
            demo();
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }


        try {
            method1("hello");
        }
        catch (ClassNotFoundException | InterruptedException ex) {
            System.out.println("Got exception: " + ex);
        }
        catch (Exception ex) {
            System.out.println("Exception is: " + ex);
        }
    }

    public static void demo() throws InterruptedException {
        Thread.sleep(100);
    }

    public static void method1(String name) throws ClassNotFoundException, InterruptedException {
        if (name.equals("hello")) {
            throw new ClassNotFoundException();
        }
        else {
            throw new InterruptedException();
        }
    }
}
