import java.util.*;

public class StreamExample {
    public static void main(String [] args) {
        List <Integer> nums = new ArrayList<>();

        nums.add(20);
        nums.add(30);
        nums.add(10);

        long output = nums.stream().filter((Integer val) -> val>15).count();
        System.out.println("Output is: " + output);
    }
}
