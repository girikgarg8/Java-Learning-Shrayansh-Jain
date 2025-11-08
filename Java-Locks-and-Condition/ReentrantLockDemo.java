import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class ReentrantLockDemo {
    private final static ReentrantLock lock = new ReentrantLock();

    public static void execute() {
        try {
            System.out.println("Thread " + Thread.currentThread().getName() + " has acquired lock");
            lock.lock();

        }
        catch (Exception ex) {


        }
        finally {
            lock.unlock();
            System.out.println("Thread " + Thread.currentThread().getName() + " has released lock");
        }
    }

    public static void main(String [] args) throws InterruptedException {
        Thread t1 = new Thread(() -> execute());
        Thread t2 = new Thread(() -> execute());

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }
};