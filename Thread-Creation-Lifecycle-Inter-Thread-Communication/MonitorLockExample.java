import java.util.*;

public class MonitorLockExample {
    public synchronized void task1() {
        try {
            System.out.println("Hello, I am task 1");
            Thread.sleep(2000);
        }
        catch (InterruptedException ex) {
            System.out.println("Thread interrupted");
            Thread.currentThread().interrupt();
        }
    }

    public void task2() {
        System.out.println("Task2, but before synchronized");
        synchronized(this) {
            System.out.println("Task2, but after synchronized");
        }
    }

    public void task3() {
        System.out.println("Task3");
    }
};