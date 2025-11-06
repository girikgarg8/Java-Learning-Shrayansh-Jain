import java.util.*;
import java.util.stream.*;

public class IntermediateOperationsDemo {
    public static void main(String [] args) {
        // filter(Predicate <T> predicate) -> filters the elements from stream
        Stream <String> nameStream = Stream.of("HELLO", "HI", "ABCD");
        Stream <String> filteredNamesStream = nameStream.filter((String name) -> name.length()<=3);
        List <String> filteredNamesList = filteredNamesStream.collect(Collectors.toList());
        System.out.println(filteredNamesList);

        // map(Function <T,R> mapper)
        Stream <String> nameStream2 = Stream.of("HELLO", "EVERYONE");
        Stream <String> output = nameStream2.map((String name)-> name.toLowerCase());
        List <String> outputList = output.collect(Collectors.toList());
        System.out.println(outputList);

        // The "flat" in flatMap refers to its ability to take a stream of collections (e.g., Stream<List<T>>) and flatten it into a single stream of elements (e.g., Stream<T>). This eliminates nested structures.

        List<List<String>> sentenceList = Arrays.asList(
                Arrays.asList("A","B","C"),
                Arrays.asList("D","E","F"),
                Arrays.asList("G","H","I")
        );

        Stream <String> wordStream = sentenceList.stream().flatMap((List <String> sentence) -> sentence.stream());
        List <String> wordsList = wordStream.collect(Collectors.toList());
        System.out.println("Words list: " + wordsList);

        Stream <String> secondStream = sentenceList.stream().flatMap((List <String> sentence) -> sentence.stream().map((String value) -> value.toLowerCase()));
        List <String> wordList2 = secondStream.collect(Collectors.toList());

        System.out.println("Word list 2" + wordList2);

        Integer [] arr = {1,2,4,4,6,7};
        Stream <Integer> arrStream = Arrays.stream(arr).distinct();
        List <Integer> arrList = arrStream.collect(Collectors.toList());
        System.out.println("Array list is: " + arrList);

        // sorted()
        Integer [] arr2 = {1,5,2,7,6,3};
        Stream <Integer> stream1 = Arrays.stream(arr2).sorted();
        stream1.collect(Collectors.toList()).forEach((Integer val) -> System.out.println("Val is: "+ val));

        Integer [] arr3 = {1,5,2,7,6,3};
        Stream <Integer> stream2 = Arrays.stream(arr3).sorted((Integer val1, Integer val2) -> val2-val1);
        List <Integer> list3 = stream2.collect(Collectors.toList());

        list3.forEach((Integer num) -> System.out.println("Number is: " + num));

        /*
            The peek method in the Java Stream API is an intermediate operation that allows you to perform an action on each element of a stream without modifying the stream itself.
             It's primarily used for debugging and observation.
         */

        List <Integer> numbers = Arrays.asList(1,2,3,4);
        Stream <Integer> numberStream = numbers.stream().filter((Integer val) -> val>=2).peek((Integer val) -> System.out.println("Value is: "+ val));
        List <Integer> numList = numberStream.collect(Collectors.toList());

        // limit (n): truncates the stream to have no longer than n elements
        Stream <Integer> numListStream = numbers.stream().limit(2);
        numListStream.collect(Collectors.toList()).forEach(num -> System.out.println("Num is: "+ num));

        // skip(n) : skips first n elements of the stream
        Stream <Integer> nums = numbers.stream().skip(2);
        nums.collect(Collectors.toList()).forEach((Integer val) -> System.out.println("Val is: "+ val));

        // mapToInt: mapToInt. Returns an IntStream consisting of the results of applying the given function to the elements of this stream.
        List <String> strList = List.of("6", "7", "8");
        IntStream intStream = strList.stream().mapToInt((String value)-> Integer.parseInt(value));
        intStream.boxed().collect(Collectors.toList()).forEach((Integer val)-> System.out.println("Number is: "+ val)); // using boxed() means converting the IntStream to Stream<Integer>

        LongStream longStream = strList.stream().mapToLong((String val)-> Long.parseLong(val));
        longStream.boxed().collect(Collectors.toList()).forEach((Long value)-> System.out.println("Value is: "+ value));

        DoubleStream doubleStream = strList.stream().mapToDouble((String value) -> Double.parseDouble(value));
        doubleStream.boxed().collect(Collectors.toList()).forEach((Double value)-> System.out.println("Double value is: " + value));

        // Lazy nature of intermediate operations
        List <Integer> numbersList = Arrays.asList(1,2,4,6,7);
        Stream <Integer> numbersStream = numbersList.stream().filter((Integer val) -> val<=3).peek((Integer value)-> System.out.println("Do I get printed: "+ value));

        // until terminal operation is not present, the intermediate operations won't get executed because of 'laxy' nature
        numbersStream.collect(Collectors.toList());

        // Sequence of stream operations
        Stream <Integer> numbersListStream = numbersList.stream().
                filter((Integer val) -> val>=3).
                peek((Integer val) -> System.out.println("After filter: "+ val)).
                map((Integer val) -> (val*-1)).
                peek((Integer val) -> System.out.println("After negating: "+ val)).
                sorted().
                peek((Integer val) -> System.out.println("After sorting: "+ val));

        numbersListStream.collect(Collectors.toList());
        // each element moves along the stream pipeline vertically one at a time (except for some stateful operations), therefore enabling optimisation where possible.
        // Refer: https://stackoverflow.com/questions/44862517/are-java-streams-stages-sequential
    }
}