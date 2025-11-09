import java.util.*;
import java.util.concurrent.*;

public class CachedThreadPoolExecutor {
    public static void main(String [] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        executor.submit(() -> {
            System.out.println("Printing hello from "+ Thread.currentThread().getName());
        });

        executor.shutdown();

    }
};