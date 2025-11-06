import java.util.*;

public class SharedResource {
    private volatile boolean itemAvailable = false;

    public synchronized void addItem() {
        itemAvailable = true;
        System.out.println("Item added by: " + Thread.currentThread().getName() + " and invoking all threads which are waiting");
        notifyAll();
    }

    public synchronized void consumeItem() {
        System.out.println("Consume item invoked by: " + Thread.currentThread().getName());

        // using while loop to avoid spurious wake-ups, sometimes because of spurious wakeups
        while (!itemAvailable) {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " is waiting now");
                wait();
            }
            catch (InterruptedException ex) {
                System.out.println("Thread interrupted");
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Item consumed by: " + Thread.currentThread().getName());
        itemAvailable = false;
    }
};