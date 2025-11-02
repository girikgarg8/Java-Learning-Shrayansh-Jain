import java.util.*;
import java.util.concurrent.*;

// The PriorityBlockingQueue class is part of the java.util.concurrent package and implements a thread-safe, priority-based blocking queue.
public class PriorityBlockingQueueDemo {
    public static void main(String [] args) {
        PriorityBlockingQueue <Integer> pq = new PriorityBlockingQueue<>(); // min heap by default in Java

        pq.add(8);
        pq.add(9);
        System.out.println(pq.peek());
    }
};