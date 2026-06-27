package priority_queue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Find the k most frequent elements in a list of integers.
 *
 * Question:
 * Given an integer list and an integer k, return the k elements that appear
 * most frequently in the list. For example, with input
 * [1, 2, 2, 3, 3, 3, 4, 4, 4, 4] and k = 2, the 2 most frequent elements are
 * [3, 4] because 4 appears 4 times and 3 appears 3 times.
 *
 * Solution:
 * Count the frequency of each number using a hash map, then maintain a min-heap
 * (priority queue) of size at most k ordered by frequency. Insert each unique
 * number into the heap and remove the least frequent item whenever the heap
 * grows beyond k. At the end, the heap contains the k most frequent elements.
 *
 * Time complexity: O(n log k), where n is the number of elements in the list.
 * Space complexity: O(n + k).
 */
public class K_most_frequent {
    /**
     * Returns the list of k most frequent integers from the input list.
     *
     * @param list the list of integers to analyze
     * @param k the number of most frequent elements to return
     * @return a list containing the k most frequent integers
     */
    private static List<Integer> mostFrequent(List<Integer> list, int k){
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int i: list){
            countMap.put(i, countMap.getOrDefault(i, 0)+1);
        }
        
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
            (a,b) -> countMap.get(a) - countMap.get(b)
        );

        for(int key: countMap.keySet()){
            priorityQueue.offer(key);
            if(priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }

        int[] result = new int[k];
        for(int i = k - 1; i >= 0; i--){
           result[i] = priorityQueue.poll();
        }

        return Arrays.stream(result).boxed().toList();
    }

    public static void main(String[] args){
        System.out.println(mostFrequent(List.of(1,2,2,3,3,3,4,4,4,4), 2));
    }
}
