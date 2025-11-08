import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class MultiThreadedCounter {
    private static int counter = 0;
    private final static AtomicInteger count = new AtomicInteger(0);

    private static void func() {
        for (int i=0;i<10000;i++) counter++;
    }

    public synchronized static void increment() {
        for (int i=0;i<10000;i++) counter++;
    }

    public static void fun() {
        for (int i=0;i<10000;i++) count.incrementAndGet();
    }

    public static void main(String [] args) throws InterruptedException {
//        Thread t1 = new Thread(() -> func());
//        Thread t2 = new Thread(() -> func());

//        Thread t1 = new Thread(() -> increment());
//        Thread t2 = new Thread(() -> increment());


        Thread t1 = new Thread(() -> fun());
        Thread t2 = new Thread(() -> fun());

        t1.start();
        t2.start();

        t1.join();
        t2.join();
//        System.out.println("Counter is: "+ counter);
       System.out.println("Count is: "+ count.get());
    }

}
