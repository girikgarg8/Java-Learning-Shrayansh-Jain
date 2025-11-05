import java.util.*;
import java.util.concurrent.*;

public class HashSetDemo {
    public static void main(String [] args) {
        Set <Integer> set1 = new HashSet<>();
        set1.add(12);
        set1.add(11);
        set1.add(33);
        set1.add(4);

        Set <Integer> set2 = new HashSet<>();
        set2.add(12);
        set2.add(16);
        set2.add(37);
        set2.add(8);

        // Union of two sets
        set1.addAll(set2);
        System.out.println("After union:");
        set1.forEach((Integer val) -> System.out.println("Value is "+ val));

        // intersection of two sets
        set1.retainAll(set2);
        set1.forEach((Integer val) -> System.out.println("Val is " + val));

        set1 = new HashSet<>();
        set1.add(12);
        set1.add(11);
        set1.add(33);
        set1.add(4);

        set2 = new HashSet<>();
        set2.add(12);
        set2.add(16);
        set2.add(37);
        set2.add(8);

        // difference of two sets
        set1.removeAll(set2);
        set1.forEach((Integer val) -> System.out.println("Value is " + val));

        final Set <Integer> set3 = new HashSet<>();

        // Concurrent Modification Exception Demo
//        Thread t1 = new Thread(() -> {
//            for (int i=0;i<1000;i++) {
//                final Integer num = i;
//                set3.add(num);
//            }
//        });
//
//        t1.start();
//        set3.forEach((Integer val) -> System.out.println("Value is " + val));

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap<>();
        Set <Integer> threadSafeSet = concurrentHashMap.newKeySet();
        threadSafeSet.add(1);
        threadSafeSet.add(2);

        Iterator <Integer> iterator = threadSafeSet.iterator();
        while (iterator.hasNext()) {
            int value = iterator.next();
            if (value == 1) {
                threadSafeSet.add(3); // we can do concurrent writes/modifications to the collection while iterating since it's a thread safe collection
            }
        }

        threadSafeSet.forEach((Integer val) -> System.out.println("Value is: " + val));
    }
};