import java.util.*;
import java.util.concurrent.*;

public class FixedThreadPoolExecutor {
    public static void main(String [] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        executor.submit(() -> {
            System.out.println("Printing hello from "+ Thread.currentThread().getName());
        });

        executor.shutdown();
    }
};