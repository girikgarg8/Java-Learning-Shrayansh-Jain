public class Main {
    public static void main(String [] args) {
        /*
            java -Xms512m -Xmx2g -Xss1m Main

            Heap Memory:
            -Xms<size>: Sets the initial heap size. The JVM will start with at least this amount of memory allocated to the heap.
            -Xmx<size>: Sets the maximum heap size. The heap will not grow beyond this size.
            Stack Memory:
            -Xss<size>: Sets the thread stack size. This determines the maximum size of the call stack for each Java thread.
         */

        System.out.println("Hi, I am running on thread: "+ Thread.currentThread().getName());
    }
}
