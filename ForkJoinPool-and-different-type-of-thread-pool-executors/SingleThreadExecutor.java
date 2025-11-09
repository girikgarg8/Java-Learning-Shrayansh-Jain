import java.util.*;
import java.util.concurrent.*;

public class SingleThreadExecutor {
    public static void main(String [] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.submit(() -> {
            System.out.println("Printing hello from "+ Thread.currentThread().getName());
        });

        executor.submit(() -> {
            System.out.println("Printing hi from "+ Thread.currentThread().getName());
        });

        executor.shutdown();
    }
};