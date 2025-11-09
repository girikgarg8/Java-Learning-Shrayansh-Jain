import java.util.*;
import java.util.concurrent.*;

public class ThreadLocalVariableDemo {
    private final static ThreadLocal <String> threadLocalObject = new ThreadLocal<>();

    public static void main(String [] args) {
        threadLocalObject.set("Hello"); // main thread is setting its thread local variable as "Hello"

        Thread t1 = new Thread(() -> {
           threadLocalObject.set("Hi"); // thread t1 is setting its thread local variable as "Hi"
           System.out.println("Thread local variable of t1 is: " + threadLocalObject.get());
        });

        t1.start();

        System.out.println("Thread local variable of main is: " + threadLocalObject.get());

        // Remember to clean up the thread local variables, if resuing the threads. Example, in the case of thread pool

        ExecutorService executor = Executors.newFixedThreadPool(5);

        executor.submit(() -> {
            System.out.println("Running set method on Thread: "+ Thread.currentThread().getName());
            threadLocalObject.set("Dummy");
            // clean up thread local variable, once task completed
            threadLocalObject.remove();
        });

        for (int i=0;i<15;i++) {
            executor.submit(() -> {
                System.out.println("Running task on Thread: "+ Thread.currentThread().getName());
                System.out.println("Thread local variable value is: " + threadLocalObject.get());
            });
        }

        executor.shutdown();

    }


}
