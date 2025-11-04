import java.util.*;

public class LinkedHashMapDemo {
    public static void main(String [] args) {
        // Linked HashMap output

        Map <String, String> linkedHashMap = new LinkedHashMap<>();

        linkedHashMap.put("A", "Hello");
        linkedHashMap.put("B", "Hi");
        linkedHashMap.put("C", "Bye");

        for (String key : linkedHashMap.keySet()) {
            System.out.println("Linkedhashmap key is: " + key);
        }

        // Normal HashMap output
        Map <String, String> hashMap = new HashMap<>();
        hashMap.put("B", "Hello");
        hashMap.put("A", "Hi");
        hashMap.put("C", "Bye");


        for (String key: hashMap.keySet()) {
            System.out.println("Hashmap key is: " + key);
        }

        Map <String, String> linkedHashMap2 = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap2.put("A", "Hello");
        linkedHashMap2.put("B", "Hi");
        linkedHashMap2.put("C", "Bye");

        linkedHashMap2.get("B");
        for (String key : linkedHashMap2.keySet()) {
            System.out.println("Linkedhashmap2 key is: " + key);
        }
    }
};