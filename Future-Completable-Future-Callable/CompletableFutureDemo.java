import java.util.*;
import java.util.concurrent.*;

public class CompletableFutureDemo {
    private static String getCurrentThreadName() {
        return Thread.currentThread().getName();
    }

    public static void main(String [] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        CompletableFuture <?> cf = CompletableFuture.supplyAsync(() -> {
            System.out.println("Completable future executing on Thread: " + getCurrentThreadName());
            return "Hello world";
        }, executor)
        .thenApplyAsync((String val) -> {
            System.out.println("Completable future 2 executing on Thread: " + getCurrentThreadName());
            return val + "Hi";
        });


        /*
        Purpose: thenCompose is used when the result of a CompletableFuture is used to initiate another asynchronous operation that itself returns a CompletableFuture.
        It effectively "flattens" the nested CompletableFutures.
         */

        CompletableFuture <?> asyncTask = CompletableFuture.supplyAsync(() -> {
            System.out.println("Thread name which runs supplyAsync "+ getCurrentThreadName());
            return "Hi";
        }, executor).thenCompose((String val) -> {
            System.out.println("Thread name which runs thenCompose: "+ getCurrentThreadName());
            return CompletableFuture.supplyAsync(() -> val + " Hello");
        }).thenAccept((String val) -> {
            System.out.println("Value is: "+ val);
        });

        cf.join();

        CompletableFuture <String> cf1 = CompletableFuture.supplyAsync(() -> {
            return "Hi ";
        }, executor);


        CompletableFuture <String> cf2 = CompletableFuture.supplyAsync(() -> {
            return "Girik";
        }, executor);

        cf1.join();
        cf2.join();

        CompletableFuture <String> cf3 = cf1.thenCombine(cf2, (String val1, String val2) -> {
            return val1+val2;
        });

        System.out.println("cf3 is: " + cf3.join());

        executor.shutdown();
    }
};