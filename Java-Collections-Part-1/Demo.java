import java.util.*;

public class Demo {
    public static void main(String [] args) {
        List <Integer> values = new ArrayList<>();
        values.add(1);
        values.add(2);
        values.add(3);

        java.util.Iterator <Integer> iterator = values.iterator();
        while (iterator.hasNext()) {
            int val = iterator.next();
            System.out.println("Element is " + val);
            if (val == 3) iterator.remove();
        }

        for (Integer num: values) {
            System.out.println("Value is: " + num);
        }

        // explore about how forEach loop internally works with the help of Consumer Functional Interface
        values.forEach(num -> System.out.println("Hi, the number is " + num));
    }
}