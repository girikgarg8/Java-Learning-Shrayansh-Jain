import java.util.*;

public class VectorDemo {
    public static void main(String [] args) {
        // Vector is similar to ArrayList, but all the perations within Vector are thread-safe
        //  it is less efficient than arrayList, since for each operation it will do lock/unlock internally

        Vector <Integer> nums = new Vector<>();
        nums.add(1);
        nums.add(2);

        nums.forEach(val -> System.out.println("Value is " + val));

    }
};