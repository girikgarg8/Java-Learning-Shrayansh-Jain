import java.util.*;

public class LinkedHashSetDemo {
    public static void main(String [] args) {
//        Set <Integer> set = Collections.synchronizedSet(new LinkedHashSet<>());

          Set <Integer> linkedHashSet = new LinkedHashSet<>();
          linkedHashSet.add(1);
          linkedHashSet.add(2);
          linkedHashSet.add(3);

          Iterator <Integer> setIterator = linkedHashSet.iterator();
          while (setIterator.hasNext()) {
              System.out.println("Next is: " + setIterator.next());
          }
    }
};