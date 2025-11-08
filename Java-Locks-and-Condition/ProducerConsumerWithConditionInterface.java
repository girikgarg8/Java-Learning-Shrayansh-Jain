import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.UUID.*;

/**
 * A Condition in ReentrantLock is a synchronization mechanism that enables a thread to suspend its execution (wait) until another thread signals that a specific program state or "condition" has become true.
 * It provides an alternative to the Object monitor methods (wait(), notify(), and notifyAll()), offering greater flexibility.
 */
public class ProducerConsumerWithConditionInterface {
    private final static ReentrantLock reentrantLock = new ReentrantLock();
    private final static Condition notEmpty = reentrantLock.newCondition();
    private final static Condition notFull = reentrantLock.newCondition();
    private final static Queue <String> buffer = new LinkedList<>();
    private final static int MAX_CAPACITY = 5;

    public static String getCurrentThreadName() {
        return Thread.currentThread().getName();
    }

    public static void produce() {
        reentrantLock.lock();
        try {
            while (buffer.size()==MAX_CAPACITY) {
                System.out.println("Producer cannot produce since buffer at full capacity");
                notFull.await(); // equivalent to monitor lock's wait()
            }
            String item = UUID.randomUUID().toString();
            buffer.add(item);
            System.out.println("Producer " + getCurrentThreadName() + " produced: "  + item);
            notEmpty.signalAll(); // equivalent to monitor lock's notifyAll()
        }
        catch (InterruptedException ex) {
            System.out.println("Got exception "+ ex);
        }
        finally {
            reentrantLock.unlock();
        }
    }

    public static void consume() {
        reentrantLock.lock();
        try {
            while (buffer.isEmpty()) {
                System.out.println("Consumer cannot consume, since buffer is empty");
                notEmpty.await(); // consumer has to wait until the buffer is not empty
            }
            String item = buffer.poll();
            System.out.println("Consumer " + getCurrentThreadName() + " consumed: "  + item);
            notFull.signalAll(); // signal to all producers that the buffer is no longer full
        }
        catch (InterruptedException ex) {
            System.out.println("Got exception "+ ex);
        }
        finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String [] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executor.submit(() -> consume());
            executor.submit(() -> produce());
        }

        Thread.sleep(6000);
        executor.shutdown();

    }
};