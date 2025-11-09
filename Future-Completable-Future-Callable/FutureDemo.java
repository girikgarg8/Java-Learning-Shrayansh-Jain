import java.util.*;
import java.util.concurrent.*;

public class FutureDemo {
    private static String getCurrentThreadName() {
        return Thread.currentThread().getName();
    }

    public static void main(String [] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        Future <String> futureObj = executor.submit(() -> {
            try {
                System.out.println("Running on thread: "+ getCurrentThreadName());
                Thread.sleep(7000);
            }
            catch (InterruptedException ex) {
                System.out.println("Got exception: "+ ex);
            }
            finally {
                return "Hello world";
            }
        });

        System.out.println("Is future completed: "+ futureObj.isDone());

        try {
            futureObj.get(2, TimeUnit.SECONDS);
        }
        catch (TimeoutException ex) {
            System.out.println("Timeout exception happened");
        }
        catch (Exception ex) {
            System.out.println("Got exception: "+ ex);
        }

        try {
            String result = futureObj.get();
            System.out.println("Result is: "+ result);
        }
        catch (InterruptedException | ExecutionException ex) {
            System.out.println("Got exception: "+ ex);
        }

        System.out.println("Is done: "+ futureObj.isDone());
        System.out.println("Is cancelled: "+ futureObj.isCancelled());

        executor.shutdown();
    }
};