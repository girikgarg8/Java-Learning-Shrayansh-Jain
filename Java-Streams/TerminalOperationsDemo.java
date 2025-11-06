import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperationsDemo {
    public static void main(String [] args) {
        // forEach(Consumer action) performs an action for each element of the stream.
        List <Integer> nums = Arrays.asList(1,2,3,4);
        nums.stream().filter((Integer num) -> num>=3).forEach((Integer value) -> System.out.println("Value is "+ value));

        // toArray() : collects elements of stream into an array
        Object [] objArray = nums.stream().filter((Integer val) -> val<=3).toArray();

        Integer [] intArray = nums.stream().filter((Integer val) -> val>3).toArray((int size)-> new Integer[size]);

        // reduce() performs associative aggregation function
        Optional <Integer> reducedValue = nums.stream().reduce((Integer val1, Integer val2) -> val1+val2);
        System.out.println("Reduced value: " + reducedValue.get());

        // min and max -> finds minimum or maximum element from stream based on the comparator provided
        Optional <Integer> minElement = nums.stream().min((Integer val1, Integer val2) -> val1-val2);
        System.out.println("Min element 1: " + minElement);
        Optional <Integer> minElement2 = nums.stream().min((Integer val1, Integer val2) -> val2-val1);
        System.out.println("Min element 2: "+ minElement2.get());

        Optional <Integer> maxElement = nums.stream().max((Integer val1, Integer val2) -> val1-val2);
        System.out.println("Max element 1: "+ maxElement.get());

        Optional <Integer> maxElement2 = nums.stream().max((Integer val1, Integer val2) -> val2-val1);
        System.out.println("Max element 2: " + maxElement2.get());

        // count() : returns the number of elements present in the stream
        long numOfValues = nums.stream().filter((Integer val)-> val>=3).count();
        System.out.println("Num values are: " + numOfValues);

        // anyMatch: checks if any value in the stream matches the given predicate
        boolean lessThanThreeAnyMatch = nums.stream().anyMatch((Integer val) -> val<=3);
        System.out.println("lessThanThreeAnyMatch: " + lessThanThreeAnyMatch);

        // allMatch: checks if all the values in the stream match the predicate
        boolean allAreLessThanHundred = nums.stream().allMatch((Integer val)-> val<100);
        System.out.println("allLessThanHundred: " + allAreLessThanHundred);

        // noneMatch: checks that all the values in the stream should not satisfy a predicate
        boolean noneShouldBeGreaterThanHundred = nums.stream().noneMatch((Integer val) -> val>100);
        System.out.println("noneShouldBeGreaterThanHundred: "+ noneShouldBeGreaterThanHundred);

        // findFirst: finds first element of the stream that satifies a given predicate
        Optional <Integer> valGreaterThanThree = nums.stream().filter((Integer val)-> val>3).findFirst();
        System.out.println("Val greater than three: "+ valGreaterThanThree.get());

        // findAny: returns any random element from the stream
        Optional <Integer> randomElement = nums.stream().filter((Integer val) -> val>=3).findAny();
        System.out.println("Random element is: " +randomElement.get());

        // once a terminal operation is used on a stream, the stream is closed/consumed. The stream cannot be used again for any other terminal operation
        Stream<Integer> numsStream = nums.stream();
        numsStream.forEach((Integer val)-> System.out.println("Value is: "+ val));

        // numsStream is already closed because a terminal operation has been applied on it. If we try to do another terminal operation on it, it will throw an error
        // Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
//        numsStream.collect(Collectors.toList());

    }
}