package prefix_sum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Check whether the array contains a contiguous subarray of length at least n
 * whose sum is a multiple of k.
 *
 * Question:
 * Given a list of integers `list`, an integer `k`, and an integer `n`,
 * determine if there exists a contiguous subarray of length >= n such that
 * the subarray sum is divisible by k. Example: list = [23,2,4,6,7],
 * k = 6, n = 2 -> true (because 2 + 4 = 6).
 *
 * Solution:
 * Use prefix sums and modular arithmetic. Track the running sum and compute
 * its remainder modulo k at each index. Store the earliest index where each
 * remainder occurs in a map (remainder -> index). If the same remainder r is
 * seen again at index i and its first occurrence was at index j, then the
 * subarray (j+1 .. i) has sum divisible by k. If i - j >= n, we have found a
 * valid subarray. Only the first occurrence of a remainder needs to be stored
 * to maximize the length (and help satisfy the length requirement n).
 *
 * Time complexity: O(m) where m is the number of elements in `list`.
 * Space complexity: O(k) for storing remainders (or up to O(m) if k is large).
 */
public class Sum_multiple_k {
    
    private static boolean isSumMultipleOfK(List<Integer> list, int k, int n){
        Map<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, 1);

        int runningSum = 0;

        for(int i = 0; i < list.size(); i++){
            runningSum += list.get(i);
            int remainder = (k == 0)? runningSum: runningSum%k;

            if(remainderMap.containsKey(remainder)){
                if(i - remainderMap.get(remainder) >= n){
                    return true;
                }
            }else{
                remainderMap.put(remainder, i);
            }
        }

        return false;
    }

    public static void main(String[] args){
        System.out.println(isSumMultipleOfK(List.of(23,2,4,6,7), 6, 2));
    }
}
