import java.util.*;


public class RecordDemo {
    public static void demo() {
        record Dummy(String id, String name) {

        }
        Dummy dummyObj = new Dummy("1", "Girik");
        System.out.println("Dummy object name is: " + dummyObj.name());
    }

    public static void main(String [] args) {
        User userObj = new User("1", "Girik", new ArrayList<>());
        System.out.println(userObj.id());
        System.out.println(userObj.name());
        System.out.println(userObj.toString());

//        List <String> names = userObj.names();
//        names.add("ABC");
//        System.out.println(userObj.names());
        User.Nested nestedObj = new User.Nested("1", "9988");

        System.out.println(nestedObj.phone());

        User.NestedStaticClass nestedStaticObj = new User.NestedStaticClass();
        nestedStaticObj.display();

        User.NonStaticNestedClass nonStaticNested = userObj.new NonStaticNestedClass();
        nonStaticNested.display();

        demo();
    }
};