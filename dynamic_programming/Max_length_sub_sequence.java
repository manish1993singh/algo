package dynamic_programming;

import java.util.Arrays;
import java.util.List;

// This class solves the Longest Increasing Subsequence (LIS) problem.
// Given a list of integers, it computes the length of the longest strictly
// increasing subsequence that can be formed by choosing elements in order.
// The algorithm uses dynamic programming with O(n^2) time complexity.
public class Max_length_sub_sequence {
    private static int getMaxlengethSubSequence(List<Integer> list){

        // If the input list is empty, there is no increasing subsequence.
        if(list.size() <= 0) return 0;

        // dp[i] will store the length of the longest increasing subsequence
        // that ends at index i.
        int[] dp = new int[list.size()];
        Arrays.fill(dp, 1); // every element is at least a subsequence of length 1

        int maxLIS = 1; // track the maximum LIS found so far

        // Build the dp array by checking all previous elements for each i.
        for(int i = 1; i < list.size(); i++){
            for(int j = 0; j < i; j++){
                // If a previous value is smaller, it can extend an increasing subsequence.
                if(list.get(j) < list.get(i)){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // Update the global maximum if the subsequence ending at i is longer.
            maxLIS = Math.max(maxLIS, dp[i]);
        }

        return maxLIS;
    }

    public static void main(String[] args){
        // Example input: longest increasing subsequence length should be 4
        // for the subsequence [2, 3, 7, 101].
        System.out.println(getMaxlengethSubSequence(List.of(10, 9, 2, 5, 3, 7, 101, 18)));
    }
}
