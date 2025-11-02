import java.util.*;

public class CollectionDemo {
    public static void main(String [] args) {
        List <Integer> values = new ArrayList<>();

        values.add(1);
        values.add(2);
        values.add(3);

        System.out.println("Size: " + values.size());
        System.out.println("isEmpty: " + values.isEmpty());
        System.out.println("contains: " + values.contains(5));
        values.add(5);

        System.out.println("added: " + values.contains(5));
        // remove using index
        values.remove(2);
        System.out.println("removed with index: " + values.contains(3));
        // remove using Object, the first occurrence of value
        values.remove(Integer.valueOf(1));
        System.out.println("removed with object: " + values.contains(1));

        Stack <Integer> stackValues = new Stack<>();
        stackValues.add(7);
        stackValues.add(8);
        stackValues.add(9);

        values.addAll(stackValues);
        System.out.println("addAll test with containsAll " + values.containsAll(stackValues));

        values.remove(Integer.valueOf(7));
        System.out.println("containsAll test after removing 1 element: " + values.containsAll(stackValues));

        // removeAll
        values.removeAll(stackValues);
        System.out.println("removeAll: "+ values.contains(8));

        // Collections util class method demo
        System.out.println("max value: " + Collections.max(values));
        System.out.println("min value: " + Collections.min(values));
        Collections.sort(values);
        values.forEach(val -> System.out.println("Value is: " + val));

        values.clear();
        System.out.println("clear: "+ values.isEmpty());
    }
}
