import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class StampedLockDemo {
    private final static StampedLock stampedLock = new StampedLock();

    private static String getCurrentThreadName() {
        return Thread.currentThread().getName();
    }

    public static void write() {
        /*
        Acquires an exclusive write lock.
        This means that once a thread successfully acquires the write lock, no other thread (neither readers nor writers) can access the critical section protected by the lock.
         */
        long stamp = stampedLock.writeLock();
        try {
            System.out.println("Write lock acquired by: " + getCurrentThreadName());
        }
        catch (Exception ex) {
            System.out.println("Received exception: " + ex);
        }
        finally {
            stampedLock.unlockWrite(stamp);
            System.out.println("Write lock released by: "+ getCurrentThreadName());
        }
    }

    public static void read() {

        /*
            Acquires a non-exclusive read lock. Multiple threads can acquire the read lock simultaneously, as long as no thread holds the write lock.
         */

        long stamp = stampedLock.readLock();
        try {
            System.out.println("Read lock acquired by: " + getCurrentThreadName());
            Thread.sleep(5000);
        }
        catch (Exception ex) {
            System.out.println("Got exception: " + ex);
        }
        finally {
            stampedLock.unlockRead(stamp);
            System.out.println("Read lock released by: "+ getCurrentThreadName());
        }
    }

    public static void main(String [] args) {
        Thread t1 = new Thread(() -> read());
        Thread t2 = new Thread(() -> read());
        Thread t3 = new Thread(() -> write());

        t1.start();
        t2.start();
        t3.start();
    }
};