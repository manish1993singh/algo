
// TreeMap Use Cases:
// 1. Storing key-value pairs in sorted order (by key).
// 2. Implementing range queries (e.g., get all entries between two keys).
// 3. Efficiently finding the smallest/largest key, or keys just above/below a given key.
// 4. Maintaining a dynamic sorted map for fast insertion, deletion, and lookup (O(log n)).
// 5. Applications: leaderboards, interval management, frequency maps, ordered caches, etc.

package java_basics;

import java.util.TreeMap;
import java.util.Map;

public class TreeMap_ {
    public static void main(String[] args) {
        // Create a TreeMap instance
        TreeMap<Integer, String> map = new TreeMap<>();

        // Put key-value pairs into the TreeMap
        map.put(3, "Three");
        map.put(1, "One");
        map.put(4, "Four");
        map.put(2, "Two");
        map.put(5, "Five");

        map.put(5, "Five_duplicate");

        // TreeMap automatically sorts keys in ascending order
        System.out.println("TreeMap (sorted by key): " + map);

        // Get the first and last key
        System.out.println("First key: " + map.firstKey());
        System.out.println("Last key: " + map.lastKey());

        // Get a submap (keys from 2 to 4)
        System.out.println("SubMap (2 to 4): " + map.subMap(2, true, 4, true));

        // Iterate over entries in sorted order
        System.out.println("Iterating over TreeMap:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // Remove a key
        map.remove(3);
        System.out.println("After removing key 3: " + map);

        // Check if a key or value exists
        System.out.println("Contains key 2? " + map.containsKey(2));
        System.out.println("Contains value 'Ten'? " + map.containsValue("Ten"));
    }
}
