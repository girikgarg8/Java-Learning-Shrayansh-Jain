import java.util.*;
import java.util.concurrent.*;

public class SemaphoreDemo {
    private final static Semaphore semaphore = new Semaphore(3);

    public static String getCurrentThreadName() {
        return Thread.currentThread().getName();
    }

    public static void execute() {
        try {
            semaphore.acquire();
            System.out.println("Thread: " + getCurrentThreadName() + " has acquired the lock");
            Thread.sleep(3000);
            System.out.println("Thread: " + getCurrentThreadName() + " is about to release the lock");
            semaphore.release();
        }
        catch (InterruptedException ex) {
            System.out.println("Got exception: " + ex);
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String [] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i=0;i<4;i++) {
            executor.submit(() -> execute());
        }

        // Initiate shutdown
        executor.shutdown();

        // Wait for termination
        if (executor.awaitTermination(8, TimeUnit.SECONDS)) {
            System.out.println("All tasks finished successfully.");
        } else {
            System.out.println("Timeout reached. Forcing shutdown.");
        }

        // Forcefully shut down if tasks are still running
        executor.shutdownNow();

    }
};