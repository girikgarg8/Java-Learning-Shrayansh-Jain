import java.util.*;
import java.util.concurrent.*;

public class RunnableCallableDemo {
    private static List <String> names = new ArrayList<>();

    public static void main(String [] args) {
        /*
            submit() method in executor is overloaded with the following three signatures:
            1. Future<?> submit(Runnable task);
            2. <T> Future<T> submit(Runnable task, T result);
            3. <T> Future<T> submit(Callable<T> task);
         */

         // Usecase 1
         ExecutorService executor = Executors.newFixedThreadPool(4);
         Future <?> future1 = executor.submit(() -> {
             System.out.println("Hello world");
         });

         try {
             Object obj = future1.get();
             System.out.println("Null check "+ (obj==null));
         }
         catch (InterruptedException | ExecutionException ex) {
            System.out.println("Got exception: "+ ex);
         }

         // Usecase-2, kind of workaround without using callable
        Future <List<String>> future2 = executor.submit(() -> {
            names.add("Girik");
        }, names); // whatever is passed as the second argument, is what is returned

        try {
            List <String> result = future2.get();
            System.out.println("Result is: "+ result);
        }
        catch (ExecutionException | InterruptedException ex) {
            System.out.println("Got exception: "+ ex);
        }

        // usecase-3
        Future <String> future3 = executor.submit(() -> {
            return "Hi";
        });

        try {
            System.out.println(future3.get());
        }
        catch (InterruptedException | ExecutionException ex) {
            System.out.println("Got exception: "+ ex);
        }

        executor.shutdown();

    }
};