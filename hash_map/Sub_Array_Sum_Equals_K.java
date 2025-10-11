package hash_map;

import java.util.HashMap;
import java.util.Map;

public class Sub_Array_Sum_Equals_K {
    public static int subarraySum(int[] numbers, int targetSum) {
        // Map to store the frequency of prefix sums
        Map<Integer, Integer> prefixSumFrequency = new HashMap<>();
        // There is one way to have a prefix sum of 0 (empty subarray)
        prefixSumFrequency.put(0, 1);
        System.out.println("Initial prefixSumFrequency: " + prefixSumFrequency);

        int currentPrefixSum = 0;
        int totalSubarrays = 0;

        for (int index = 0; index < numbers.length; index++) {
            int currentNumber = numbers[index];
            currentPrefixSum += currentNumber;
            System.out.println("Step " + index + ": currentNumber=" + currentNumber + ", currentPrefixSum=" + currentPrefixSum);

            // Check if there is a prefix sum that, if removed, leaves a subarray sum of targetSum
            int neededPrefixSum = currentPrefixSum - targetSum;
            if (prefixSumFrequency.containsKey(neededPrefixSum)) {
                totalSubarrays += prefixSumFrequency.get(neededPrefixSum);
                System.out.println("  Found neededPrefixSum: " + neededPrefixSum + ", incremented by " + prefixSumFrequency.get(neededPrefixSum) + ", new totalSubarrays=" + totalSubarrays);
            } else {
                System.out.println("  No neededPrefixSum found for: " + neededPrefixSum);
            }

            // Update the frequency of the current prefix sum
            prefixSumFrequency.put(currentPrefixSum, prefixSumFrequency.getOrDefault(currentPrefixSum, 0) + 1);
            System.out.println("  Updated prefixSumFrequency: " + prefixSumFrequency);
        }

        System.out.println("Final totalSubarrays: " + totalSubarrays);
        return totalSubarrays;
    }

    public static void main(String[] args) {
    int[] numbers = {5, 1, 2, 3, -5, 8, -3};
    int targetSum = 3;
    System.out.println("Number of subarrays with sum equal to " + targetSum + ": " + subarraySum(numbers, targetSum));
    }
}
