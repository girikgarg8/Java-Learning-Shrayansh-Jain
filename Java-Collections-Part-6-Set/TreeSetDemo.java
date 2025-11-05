import java.util.*;

public class TreeSetDemo {
    public static void main(String [] args) {
        Set <Integer> treeSet = new TreeSet<>();

        treeSet.add(90);
        treeSet.add(99);
        treeSet.add(100);

        Iterator <Integer> treeSetIterator = treeSet.iterator();
        while (treeSetIterator.hasNext()) {
            System.out.println("Value is: " + treeSetIterator.next());
        }

    }
};