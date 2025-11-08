import java.util.*;
import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {
    private static final int CORE_POOL_SIZE = 2;
    private static final int MAXIMUM_POOL_SIZE = 5;

    private static String getCurrentThreadName() {
        return Thread.currentThread().getName();
    }

    public static void main(String [] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10), new CustomThreadFactory(), new CustomRejectionHandler());

        executor.allowCoreThreadTimeOut(true); // determines whether core threads are subject to the keepAliveTime policy.

        // submit tasks
        for (int i=0; i<25; i++) {
            final int taskId = i;
            executor.submit(() -> {
                try {
                    System.out.println("Executing " + taskId + " on thread: "+ getCurrentThreadName());
                    Thread.sleep(10000);
                }
                catch (Exception ex) {

                }
            });
        }
    }

    static class CustomThreadFactory implements ThreadFactory {
        @Override
        public Thread newThread(Runnable r) {
            Thread th = new Thread(r);
            th.setDaemon(false);
            return th;
        }
    };

    static class CustomRejectionHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("Task denied: " + r.toString());
        }
    };

};