package prefix_sum;
import java.util.ArrayList;
import java.util.List;

/**
 * Count contiguous subarrays whose sum is greater than or equal to k.
 *
 * Problem:
 * Given an integer array that may contain negative values, determine how many
 * subarrays have a sum >= k.
 *
 * Approach:
 * - Build prefix sums for the array.
 * - Maintain a sorted list of prefix sums seen so far.
 * - For current prefix sum P, any earlier prefix sum S satisfying
 *   S <= P - k indicates a subarray sum >= k.
 * - Use binary search in the sorted prefix list to count those valid S values.
 */
public class Sum_x_greator_or_equal {

    private static int count(List<Integer> arr, int k){
        int count = 0;
        int prefixSum = 0;

        // Sorted prefix sums seen so far.
        List<Integer> sortedPrefixList = new ArrayList<>();

        // Include 0 so subarrays starting at index 0 are counted correctly.
        sortedPrefixList.add(0);

        for(int value : arr){
            prefixSum += value;

            // We need earlier prefix sums S such that S <= prefixSum - k.
            // That means the subarray sum from the next index after S to the
            // current index is at least k.
            int target = prefixSum - k;
            int index = findFirstGreatestOrEqual(sortedPrefixList, target);

            // All prefix sums at positions index..end satisfy the condition.
            count += sortedPrefixList.size() - index;

            // Insert current prefix sum while keeping the list sorted.
            int insertPos = findFirstGreatestOrEqual(sortedPrefixList, prefixSum);
            sortedPrefixList.add(insertPos, prefixSum);

            // Debug output to trace the sorted prefix sums.
            System.out.println(sortedPrefixList);
        }

        return count;
    }

    private static int findFirstGreatestOrEqual(List<Integer> list, int value){
        int low = 0;
        int high = list.size();

        // Binary search for the first index where list.get(index) >= value.
        while(low < high){
            int mid = low + (high - low) / 2;
            if(list.get(mid) < value) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args){
        List<Integer> input1 = List.of(1, -1, 2, 3);
        int k1 = 3;

        // Example: count subarrays with sum >= 3.
        System.out.println(count(input1, k1));
    }
}
 