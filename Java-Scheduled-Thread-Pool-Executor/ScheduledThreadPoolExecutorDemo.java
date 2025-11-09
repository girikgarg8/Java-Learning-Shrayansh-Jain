import java.util.*;
import java.util.concurrent.*;

public class ScheduledThreadPoolExecutorDemo {
    private static String getCurrentThreadName() {
        return Thread.currentThread().getName();
    }

    public static void main(String [] args) {
        ScheduledExecutorService scheduledExecutor = new ScheduledThreadPoolExecutor(5);

        // one time run only
        scheduledExecutor.schedule(() -> {
            System.out.println("Running task on Thread: "+ getCurrentThreadName());
        }, 3, TimeUnit.SECONDS);

        Future <?> future = scheduledExecutor.scheduleAtFixedRate(() -> {
            System.out.println("Running scheduled task at fixed rate on Thread: "+ getCurrentThreadName());
        }, 4, 2, TimeUnit.SECONDS);

        scheduledExecutor.scheduleWithFixedDelay(() -> {
            System.out.println("Running scheduled task at fixed delay on Thread: "+ getCurrentThreadName());
        }, 5, 3, TimeUnit.SECONDS);

        // after 15 seconds, cancel the future as the scheduled task is no longer required
        try {
            Thread.sleep(15000);
        }
        catch (InterruptedException ex) {
            System.out.println("Got exception: "+ ex);
        }
        future.cancel(true);
    }
};