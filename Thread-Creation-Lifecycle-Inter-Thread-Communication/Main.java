import java.util.*;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hi, I am running on " + Thread.currentThread().getName());
    }
};

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello, I am running on: "+ Thread.currentThread().getName());
    }
};

public class Main {
    public static void main(String [] args) throws InterruptedException {
        Runnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable);
        Thread t2 = new MyThread();
        t1.start();
        t1.join();
        t2.start();
        MonitorLockExample monitorLockExample = new MonitorLockExample();

        Thread t3 = new Thread(() -> monitorLockExample.task1());
        Thread t4 = new Thread(() -> monitorLockExample.task2());
        Thread t5 = new Thread(() -> monitorLockExample.task3());

        t3.start();
        t4.start();
        t5.start();
    }
}
