package java_basics;

import java.util.TreeSet;

// TreeSet Use Cases:
// 1. Maintaining a sorted set of unique elements (e.g., leaderboards, unique scores).
// 2. Efficiently finding the smallest/largest element, or elements just above/below a given value.
// 3. Range queries (e.g., get all elements between two values).
// 4. Removing duplicates and keeping data sorted automatically.
// 5. Applications: event scheduling, interval management, real-time ranking, etc.

public class TreeSet_ {
    public static void main(String[] args) {
        // Create a TreeSet instance
        TreeSet<Integer> set = new TreeSet<>();

        // Add elements to the TreeSet
        set.add(3);
        set.add(1);
        set.add(4);
        set.add(2);
        set.add(5);
        set.add(2); // Duplicate, will not be added

        // TreeSet automatically sorts elements and removes duplicates
        System.out.println("TreeSet (sorted, unique): " + set);

        // Get the first and last element
        System.out.println("First element: " + set.first());
        System.out.println("Last element: " + set.last());

        // Get a subset (elements from 2 to 4)
        System.out.println("Subset (2 to 4): " + set.subSet(2, true, 4, true));

        // Iterate over elements in sorted order
        System.out.println("Iterating over TreeSet:");
        for (Integer value : set) {
            System.out.println("Value: " + value);
        }

        // Remove an element
        set.remove(3);
        System.out.println("After removing 3: " + set);

        // Check if an element exists
        System.out.println("Contains 2? " + set.contains(2));
        System.out.println("Contains 10? " + set.contains(10));
    }
}
