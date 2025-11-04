import java.util.*;

public class TreeMapDemo {
    public static void main(String [] args) {
        TreeMap <Integer, Integer> treeMap = new TreeMap<>();

        treeMap.put(1,1);
        treeMap.put(99,1);
        treeMap.put(2,3);

        System.out.println(treeMap.headMap(2)); //prints the path from head to 2 (2 excluded) : 1
        System.out.println(treeMap.tailMap(2)); //prints the path from 2 to tail (2 included) : 2,99
        System.out.println(treeMap.firstKey()); // first element in sorted array: 1
        System.out.println(treeMap.lastKey()); // last element in sorted array: 99

        // lowerEntry(K key) in NavigableMap: This method returns a Map.Entry<K, V> (key-value mapping) associated with the greatest key strictly less than the given key. If no such key exists, it returns null.
        System.out.println("Lower entry is " + treeMap.lowerEntry(2));
        System.out.println("Lower entry 2 is " + treeMap.lowerEntry(1));

        // The lowerKey() method in the java.util.NavigableMap interface returns the greatest key strictly less than the given key
        System.out.println("Lower key is: " + treeMap.lowerKey(2));
        System.out.println("Lower key 2 is: " + treeMap.lowerKey(2));

        // The floorEntry() method in Java's NavigableMap interface is used to retrieve a key-value mapping (an Entry) from the map. Specifically, it returns the Map.Entry associated with the greatest key less than or equal to the given key. If no such key exists in the map, the method returns null.
        System.out.println("Floor entry is: "+ treeMap.floorEntry(2));
        System.out.println("Floor entry is: "+ treeMap.floorEntry(-1));

        // The floorKey() method in the java.util.NavigableMap interface is used to retrieve the greatest key in the map that is less than or equal to a specified key.
        System.out.println("Floor key is: "+ treeMap.floorKey(2));
        System.out.println("Floor key is: "+ treeMap.floorKey(-1));

        // The ceilingEntry() method in the java.util.NavigableMap interface is used to retrieve a key-value mapping (a Map.Entry) from the map. Specifically, it returns the mapping associated with the least key that is greater than or equal to the given key. If no such key exists in the map, the method returns null.
        System.out.println("Ceiling entry is: " + treeMap.ceilingEntry(3));
        System.out.println("Ceiling entry is: " + treeMap.ceilingEntry(100));

        // The ceilingKey() method in Java's NavigableMap interface is used to retrieve the least key within the map that is greater than or equal to a specified key. If no such key exists in the map, the method returns null

        System.out.println("Ceiling key is: " + treeMap.ceilingKey(3));
        System.out.println("Ceiling key is: " + treeMap.ceilingKey(100));

        // The higherEntry(K key) method returns a Map.Entry<K, V> object representing the key-value mapping associated with the least key that is strictly greater than the provided key
        System.out.println("Higher entry is: " + treeMap.higherEntry(56));
        System.out.println("Higher entry 2 is: " + treeMap.higherEntry(1009));

        // The higherKey() method in Java's NavigableMap interface serves to retrieve the least key that is strictly greater than a specified key within the map.
        System.out.println("Higher entry is: " + treeMap.higherKey(56));
        System.out.println("Higher entry 2 is: " + treeMap.higherKey(1009));

        // firstEntry() Method: This method returns a Map.Entry<K, V> object representing the key-value pair with the smallest key in the NavigableMap.
        System.out.println("First entry is: "+ treeMap.firstEntry());

        // The lastEntry() method in Java's NavigableMap interface retrieves the key-value mapping associated with the greatest key in the map.
        System.out.println("Last entry is: "+ treeMap.lastEntry());

        // The pollFirstEntry() method in the NavigableMap interface in Java is used to remove and return the key-value mapping associated with the least key in the map. If the map is empty, this method returns null.
        System.out.println("first entry polled is: "+ treeMap.pollFirstEntry());
//        System.out.println("last entry polled is: "+ treeMap.pollLastEntry());

        // The descendingMap() method in a NavigableMap interface in Java provides a reverse-order view of the mappings contained in the original map. This means that if the original NavigableMap is sorted in ascending order of keys, the descendingMap() method will return a new NavigableMap where the elements are ordered by keys in descending order.
        Map <Integer, Integer> treeMapReversed = treeMap.descendingMap();
        System.out.println("Reversed tree map: " + treeMapReversed);

        // The navigableKeySet() method in the NavigableMap interface returns a NavigableSet containing the keys of the map in ascending order
        System.out.println(treeMap.navigableKeySet());

        // The descendingKeySet() method in the NavigableMap interface returns a NavigableSet view of the map's keys in reverse order
        System.out.println(treeMap.descendingKeySet());
    }
}