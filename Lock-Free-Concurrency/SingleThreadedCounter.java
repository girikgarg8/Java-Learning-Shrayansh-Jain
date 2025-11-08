import java.util.*;

public class SingleThreadedCounter {
    private static int counter = 0;

    public static void main(String [] args) {
        for (int i=0;i<1000;i++) counter++;
        System.out.println("Counter is: "+ counter);
    }
};