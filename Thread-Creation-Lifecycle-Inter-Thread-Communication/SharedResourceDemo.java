public class SharedResourceDemo {
    public static void main(String [] args) {
        System.out.println("Main thread start");

        SharedResource sharedResource = new SharedResource();

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(2000);
                sharedResource.addItem();
            }
            catch (InterruptedException ex) {
                System.out.println("Thread interrupted");
                Thread.currentThread().interrupt();
            }
        });

        Thread t2 = new Thread(() -> {
            sharedResource.consumeItem();
        });

        t1.start();
        t2.start();
    }
};