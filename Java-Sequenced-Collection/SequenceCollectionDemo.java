import java.util.*;
import java.util.concurrent.*;

// Use JDK 21 or above since SequenceCollection was introduced in Java 21
public class SequenceCollectionDemo {
    public static void main(String [] args) {
        List <String> list = new ArrayList<>(List.of("A","B","C"));

        // Access
        System.out.println(list.getFirst());
        System.out.println(list.getLast());

        // Add
        list.addFirst("D");
        list.addLast("E");

        // remove
        list.removeFirst();
        list.removeLast();

        // reversed
        System.out.println(list.reversed());

        Deque <String> deque = new ArrayDeque<>(List.of("B", "C", "D"));

        // Access
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());

        // Add
        deque.addLast("A");
        deque.addFirst("E");

        // remove
        deque.removeFirst();
        deque.removeLast();

        // reversed
        System.out.println(deque.reversed());

        SequencedSet <String> set = new LinkedHashSet<>(List.of("B", "A"));
        // Access
        System.out.println(set.getFirst());
        System.out.println(set.getLast());

        // Add
        set.addFirst("C");
        set.addLast("D");

        // Remove
        set.removeFirst();
        set.removeLast();

        // Reverse
        System.out.println(set.reversed());

        SequencedSet <Integer> sortedSet = new TreeSet<>(Set.of(1,3,2));

        // Access
        System.out.println(sortedSet.getFirst());
        System.out.println(sortedSet.getLast());

        /*
        as SortedSet sort the values as when inserted, so addFirst() and addLast() method
        do not make sense, that’s why this method throws UnsupportedOperationException.
         */
        try {
            sortedSet.addFirst(9);
        }
        catch (UnsupportedOperationException ex) {
            System.out.println("Got unsupported operation exception on sorted set add first");
        }

        try {
            sortedSet.addLast(9);
        }
        catch (UnsupportedOperationException ex) {
            System.out.println("Got unsupported operation exception on sorted set add last");
        }

        // add
        sortedSet.add(2);
        sortedSet.add(25);

        // remove
        sortedSet.removeFirst();
        sortedSet.removeLast();

        // reversed view
        System.out.println(sortedSet.reversed());

        SequencedMap <Integer, String> sequencedMap = new LinkedHashMap<>();
        sequencedMap.put(100, "A");
        sequencedMap.put(200, "B");

        // Access
        System.out.println(sequencedMap.firstEntry());
        System.out.println(sequencedMap.lastEntry());

        // Add
        sequencedMap.putFirst(300, "C");
        sequencedMap.putLast(400, "D");

        // Remove
        sequencedMap.pollFirstEntry();
        sequencedMap.pollLastEntry();

        // reversed view
        System.out.println(sequencedMap.reversed());

        SequencedMap <Integer, String> sortedMap = new TreeMap<>();

        // Add
        sortedMap.put(100, "A");
        sortedMap.put(200, "B");

        /*
        as SortedMap sort the values as when inserted, so putFirst() and putLast() method,
        do not make sense, that’s why this method throws UnsupportedOperationException.
         */

        try {
            sortedMap.putFirst(300, "C");
        }
        catch (UnsupportedOperationException ex) {
            System.out.println("Got unsupported operation exception for sorted map put first");
        }

        try {
            sortedMap.putLast(300, "C");
        }
        catch (UnsupportedOperationException ex) {
            System.out.println("Got unsupported operation exception for sorted map put last");
        }

        // Remove
        sortedMap.pollFirstEntry();
        sortedMap.pollLastEntry();

        System.out.println(sortedMap.reversed());

    }
};