import java.util.*;

public class VarArgsDemo {
    public void print(String ...nums){
        for (String item: nums) {
            System.out.println("Received item: " + item);
        }
    }

    @SafeVarargs
    public final void func(List <Integer> ...nums) {
        Object [] objectList = nums;
        objectList[0] = List.of("Hi");
    }
}