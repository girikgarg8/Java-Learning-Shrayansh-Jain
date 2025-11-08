import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class ReentrantReadWriteLockDemo {
    private final static ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    private static String getCurrentThreadName() {
        return Thread.currentThread().getName();
    }

    public static void read() {
        try {
            rwLock.readLock().lock();
            System.out.println("Read lock acquired by thread: " + getCurrentThreadName());
            Thread.sleep(5000);
            System.out.println("Read lock released by thread:" + getCurrentThreadName());
        }
        catch (InterruptedException ex) {
            System.out.println("Thread interrupted");
            Thread.currentThread().interrupt();
        }
        finally {
            rwLock.readLock().unlock();
        }
    }

    public static void write() {
        rwLock.writeLock().lock();
        System.out.println("Write lock acquired by thread: " + getCurrentThreadName());
        rwLock.writeLock().unlock();
    }

    public static void main(String [] args) throws InterruptedException {
        Thread t1 = new Thread(() -> read());
        Thread t2 = new Thread(() -> read());
        Thread t3 = new Thread(() -> write());

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
};