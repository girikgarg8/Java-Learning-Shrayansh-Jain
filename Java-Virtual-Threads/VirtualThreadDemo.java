import java.util.*;
import java.util.concurrent.*;

public class VirtualThreadDemo {
    public static void main(String [] args) throws InterruptedException {
        Runnable task = () -> {
            System.out.println("Hello from a virtual thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Virtual thread " + Thread.currentThread().getName() + " finished.");
        };

       Thread virtualThread = Thread.ofVirtual().name("MyVirtualThread").start(task);
        virtualThread.join();


        /**
         * Executors.newVirtualThreadPerTaskExecutor() creates a new virtual thread for every new task submitted to it. This is the core characteristic of this executor.
         * Unlike traditional thread pool executors that reuse a fixed or bounded number of platform threads,
         * newVirtualThreadPerTaskExecutor() specifically designs for the virtual thread model, where creating and discarding threads is very cheap. This allows for a "thread-per-task" approach without incurring the overhead associated with creating numerous platform threads.
         */
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 5; i++) {
                int taskId = i;
                executor.submit(() -> {
                    System.out.println("Task " + taskId + " running on " + Thread.currentThread());
                    try { Thread.sleep(500); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                    System.out.println("Task " + taskId + " finished.");
                });
            }
        }

        System.out.println("Main thread finished");
    }
}
