import java.util.*;

class Dummy {
    public synchronized void sayHello() {
        System.out.println("Thread " + Thread.currentThread().getName() + " is executing");
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
};

public class SuspendDemo {
    public static void main(String [] args) throws InterruptedException {
        System.out.println("Main thread is starting execution");
        Dummy dummyObj = new Dummy();
        Thread t1 = new Thread(() -> dummyObj.sayHello());
        t1.start();
        Thread.sleep(100);
        t1.suspend();
        Thread t2 = new Thread(() -> dummyObj.sayHello());
//        t1.resume();
        t2.start();
        System.out.println("Main thread is finishing execution");
    }
};