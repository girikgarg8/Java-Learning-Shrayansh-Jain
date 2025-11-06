import java.util.*;
import java.util.stream.Stream;

public class StreamCreation {
    public static void main(String [] args) {
        // using Collection.stream()
        List <Integer> nums = new ArrayList<>();
        Stream<Integer> stream = nums.stream();

        Integer [] numsArray = {1,2,3,4};
        Stream <Integer> stream2 = Arrays.stream(numsArray);

        Stream <Integer> streamFromStaticMethod = Stream.of(10,20,30);

        Stream.Builder <Integer> streamBuilder = Stream.builder();
        streamBuilder.add(100).add(200);

        Stream <Integer> streamFromBuilder = streamBuilder.build();

        /*
        It creates an infinite stream starting at 1000 and repeatedly adds 500: 1000, 1500, 2000, …
        The lambda (Integer n) -> n + 500 defines the step.
        limit(5) takes only the first 5 numbers.
        So the stream contains: 1000, 1500, 2000, 2500, 3000.
         */

        Stream <Integer> streamFromIterate = Stream.iterate(1000, (Integer n) -> n+500).limit(5);

    }
};