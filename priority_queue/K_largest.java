package priority_queue;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Find the k-th largest element in an unsorted list of integers.
 *
 * Question:
 * Given an array of integers and an integer k, return the k-th largest
 * element in the array. For example, in [3, 2, 1, 5, 6, 4] with k = 2,
 * the 2nd largest element is 5.
 *
 * Solution:
 * This implementation maintains a min-heap of size at most k.
 * We add every number to the heap, and when the heap grows larger than k,
 * we remove the smallest value. At the end, the heap contains the k largest
 * elements, and the root of the min-heap is the k-th largest element.
 *
 * Time complexity: O(n log k) where n is the number of elements.
 * Space complexity: O(k).
 */
public class K_largest {
    /**
     * Returns the k-th largest element from the input list.
     *
     * @param arr the list of integers to search
     * @param k the position of the largest element to return (1-based)
     * @return the k-th largest integer in the list
     */
    private static int kthLargest(List<Integer> arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i: arr){
            pq.add(i);
            if(pq.size() > k){
                pq.poll();
            }
        }

        return pq.poll();
    }

    public static void main(String[] args){
        System.out.println(kthLargest(List.of(3,2,1,5,6,4), 2));
    }
}
