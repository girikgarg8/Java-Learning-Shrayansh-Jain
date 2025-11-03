import java.util.*;

public class HashMapDemo {
    public static void main(String [] args) {
        Map <Integer, String> rollNumberVsNameMap = new HashMap<>();

        rollNumberVsNameMap.put(null,"TEST");
        rollNumberVsNameMap.put(1, "A");
        rollNumberVsNameMap.put(2, "B");

        // put if Absent
        rollNumberVsNameMap.putIfAbsent(null, "test");
        rollNumberVsNameMap.putIfAbsent(0, "ZERO");
        rollNumberVsNameMap.putIfAbsent(3, "C");

        // Map.Entry is a sub interface of Map interface
        for (Map.Entry <Integer, String> entry: rollNumberVsNameMap.entrySet()) {
            System.out.println("Key: " + entry.getKey());
            System.out.println("Value: " + entry.getValue());
        }

        //isEmpty
        System.out.println("Is map empty: " + rollNumberVsNameMap.isEmpty());

        // Size
        System.out.println("Map size: " + rollNumberVsNameMap.size());

        // containsKey
        System.out.println("Contains key 1: " + rollNumberVsNameMap.containsKey(1));

        // get
        System.out.println("Map value for key 1: " + rollNumberVsNameMap.get(1));

        // getOrDefault(key)
        System.out.println("get(9): " + rollNumberVsNameMap.getOrDefault(9999, "98"));

        // remove(key)
        System.out.println(rollNumberVsNameMap.remove(2));

        for (Map.Entry <Integer, String> entry: rollNumberVsNameMap.entrySet()) {
            System.out.println("Key: " + entry.getKey());
            System.out.println("Value: " + entry.getValue());
        }

        // keySet()
        for (Integer key: rollNumberVsNameMap.keySet()) {
            System.out.println("Key is: "+ key);
        }

        // values()
        Collection <String> values = rollNumberVsNameMap.values();
        values.forEach(num -> System.out.println("Num is: " + num));
    }
};