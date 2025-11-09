import java.util.*;
import java.util.concurrent.*;

public class awaitTerminationDemo {
    public static void main(String [] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        executor.submit(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("Task running on Thread: " + Thread.currentThread().getName());
            } catch (InterruptedException ex) {
                System.out.println("Got exception: " + ex);
            }
        });

        executor.shutdown();

        // Cannot submit a task to executor once it has been shut down
//        executor.submit(() -> {
//            System.out.println("Task running on Thread: "+ Thread.currentThread().getName());
//        });
        if (executor.awaitTermination(1, TimeUnit.SECONDS)) {
            System.out.println("Executor has been terminated");
        }
        else {
            System.out.println("Executor not yet terminated");
        }


    }
};