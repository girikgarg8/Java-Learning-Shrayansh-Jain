import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

// Stamped lock allows lock-free reads with later validation, offering high performance in read-heavy scenarios
// This is what sets Stamped Lock apart from Reentrant Read Write Lock, where all reads are pessimistic, requiring an explicit read lock

public class OptimisticReadWithStampedLock {
    private final static StampedLock stampedLock = new StampedLock();
    private static int number = 10;

    public static String getCurrentThreadName() {
        return Thread.currentThread().getName();
    }

    public static void read() {
        long stamp = stampedLock.tryOptimisticRead();
        try {
            System.out.println("Taking optimistic lock");
            Thread.sleep(5000); // making the current thread sleep so that the writer thread can do its operation meanwhile and then the optimistic check in the end would fail
            if (stampedLock.validate(stamp)) {
                System.out.println("Number is: " + number);
            }
            else {
                System.out.println("Entity version mismatch"); // current stamp doesn't match the stamp acquired at beginning of transaction
            }
        }
        catch (Exception ex) {
            System.out.println("Got exception: " + ex);
        }
    }

    public static void write() {
        long stamp = stampedLock.writeLock();
        System.out.println("Write lock acquired by: "+ getCurrentThreadName());
        try {
            System.out.println("Performing work");
            number = 9;
        }
        finally {
            stampedLock.unlockWrite(stamp);
            System.out.println("Write lock released by: "+ getCurrentThreadName());
        }
    }

    public static void main(String [] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
           read();
        });

        Thread.sleep(500);

//        Thread t2 = new Thread(() -> {
//            write();
//        });

        t1.start();
//        t2.start();
    }
};
