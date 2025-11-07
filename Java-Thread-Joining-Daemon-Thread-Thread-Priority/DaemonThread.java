import java.util.*;

public class DaemonThread {
    public static void main(String [] args) {
        /*
        A daemon thread in Java is a thread that runs in the background and serves as a helper thread to support other threads. Unlike user threads, daemon threads do not prevent the JVM from exiting, and the JVM terminates any daemon threads automatically once all non-daemon (user) threads have finished executing.
        They are typically used for tasks like garbage collection, background monitoring, or housekeeping services.
         By default, threads are non-daemon, but you can mark a thread as a daemon thread by calling setDaemon(true) before starting it.
         */

        System.out.println("Main thread starting execution");

        Thread t1 = new Thread(() -> {
            try {
                System.out.println("T1 thread going to sleep");
                Thread.sleep(9000);
                System.out.println("T1 thread woke up"); // will not get chance to execute, since daemon thread will terminate as soon as non-daemon threads are finished
            }
            catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        });
        t1.setDaemon(true);

        t1.start();

        System.out.println("Main thread exiting");

    }
};