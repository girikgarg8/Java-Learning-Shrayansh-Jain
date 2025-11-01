import java.util.*;

public class TryCatchFinallyDemo {
    public static void main(String [] args) throws ClassNotFoundException ,InterruptedException {
        try {
            method1("hello");
            return ;
        }
        catch (ClassNotFoundException | InterruptedException ex) {
            throw ex;
        }
        finally {
            System.out.println("Inside finally");
        }
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
