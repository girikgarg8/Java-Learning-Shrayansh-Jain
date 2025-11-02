import java.util.*;

public class PriorityQueueDemo {
    public static void main(String [] args) {
        // in Java, by default the priority queue is a min priority queue, in contrast to C++ where priority queue is max priority queue by default
        PriorityQueue<Integer> minPq = new PriorityQueue<>();

        minPq.add(10);
        minPq.add(15);
        minPq.add(7);

        // when iterating over priority queue with for loop, the elements will be returned in the same order as level order traversal of heap.
        // Not in the min/max order of elements in the heap
        minPq.forEach(val -> System.out.println("Value is: " + val));

        while (!minPq.isEmpty()) {
            Integer item = minPq.poll();
            System.out.println("Item is: " + item);
        }

        PriorityQueue <Integer> maxPq = new PriorityQueue<>((Integer a, Integer b) -> b-a);
        maxPq.add(7);
        maxPq.add(15);
        maxPq.add(10);

        maxPq.forEach(val -> System.out.println("Value is: " + val));

        while (!maxPq.isEmpty()) {
            Integer item = maxPq.poll();
            System.out.println("Got value: " + item);
        }
    }
}
