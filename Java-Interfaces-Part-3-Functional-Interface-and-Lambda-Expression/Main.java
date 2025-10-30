import java.util.*;
import java.util.function.*;

public class Main {
    public static void main(String [] args) {
        TestClass obj = new TestClass();
        System.out.println(obj.toString());

        Bird bird = new Bird() {
            @Override
            public void fly() {
                System.out.println("My bird flying");
            }
        };

        bird.fly();

        Bird birdObj = () -> System.out.println("Lambda bird flying");
        birdObj.fly();

        Consumer <Integer> consumer = (Integer val) -> {
            if (val > 10) {
                System.out.println("Value greater than 10");
            }
        };

        Supplier supplier = () -> {
            return 1009;
        };

        consumer.accept(11);
        System.out.println(supplier.get());

        Function <Integer, String> func = (Integer num) -> {
            return num.toString();
        };

        System.out.println(func.apply(102));

        Predicate <String> predicate = (String value) -> {
            return "Hello".equals(value);
        };

        System.out.println(predicate.test("Hello"));

        DemoChild demoChild = () -> System.out.println("DemoChild");

        demoChild.demo();
    }
}