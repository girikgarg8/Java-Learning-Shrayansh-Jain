import java.util.*;
import java.util.stream.Collectors;

public class ParallelStreamDemo {
    public static void main(String [] args) {
        /*
        Parallel stream does two things internally:
        1. Task splitting: Use "splitIterator" function to split the data into multiple chunks
        2. Task submission and parallel processing: Uses Fork-Join Pool technique
         */

        List <Integer> nums = Arrays.asList(1,2,5,2,3,1,2,4,5,2,2,4,2);
        long sequentialProcessingStartTime = System.currentTimeMillis();
        nums.stream().map((Integer val)-> val*val).collect(Collectors.toList());
        System.out.println("Time taken sequential: "+ (System.currentTimeMillis()-sequentialProcessingStartTime));

        long parallelProcessingStartTime = System.currentTimeMillis();
        nums.parallelStream().map((Integer val)-> val*val).collect(Collectors.toList());
        System.out.println("Time taken sequential: "+ (System.currentTimeMillis()- parallelProcessingStartTime));


    }
};