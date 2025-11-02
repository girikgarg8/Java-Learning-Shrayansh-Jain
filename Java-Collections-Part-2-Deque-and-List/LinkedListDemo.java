import java.util.*;

public class LinkedListDemo {
    public static void main(String [] args) {
        // LinkedList implements both Deque and List interfaces, hence it has methods from both
        // Deque related methods: getFirst(), getLast(), removeFirst(), removeLast() etc
        // List related methods: get(index), add(index, object)

        // using deque functionality
        LinkedList <Integer> list = new LinkedList<>();
        list.addLast(200);
        list.addLast(300);
        list.addLast(100);
        System.out.println("Last element is: " + list.getFirst());

        // using list functionality
        LinkedList <Integer> list2 = new LinkedList<>();
        list2.add(0,199);
        list2.add(1,200);
        list2.add(2,201);

        System.out.println(list2.get(1) + " and " + list2.get(2));

    }
};