import java.util.*;

public class PatternMatchingDemo {
    public static void main(String [] args) {
        Object obj = new User("14");

        if (obj instanceof User) {
            User userObj = (User) obj;
            System.out.println(userObj.getId());
        }

        // New pattern matching method Available since JDK 16
        // first comparison happens, if true, then it is automatically type casted and initialized
        if (obj instanceof User u && u.getId().equals("14")) {
            System.out.println(u.getId());
        }

        Object obj2 = new Car();
        if (obj2 instanceof Vehicle v) {
            v.drive();
        }

    }
}
