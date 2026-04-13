package Kadane;

/**
 * Find the contiguous subarray with the largest product.
 * 
 * Algorithm: Modified Kadane's Algorithm
 * Track both maximum and minimum products ending at each position because:
 * - A negative number can turn a large negative product into a large positive product
 * - A negative number can turn a large positive product into a large negative product
 */
public class MaxProductSubarray {
    public static int maxProduct(int[] nums) {
        // Edge case: empty or null array returns 0
        if (nums == null || nums.length == 0) return 0;

        // Initialize tracking variables with the first element
        int maxSoFar = nums[0];    // Maximum product ending at current position
        int minSoFar = nums[0];    // Minimum product ending at current position
        int result = nums[0];      // Global maximum product found
        int result2 = nums[0];     // Global minimum product found (for debugging)

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            
            /* 
               Handle negative numbers: swap max and min because multiplication
               by a negative number reverses the relationship.
               Example: if max=5 and min=-3, after multiplying by -2:
               new max = -3 * (-2) = 6, new min = 5 * (-2) = -10
            */
            if (current < 0) {
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }

            // Update max product: either start fresh at current element or extend previous max
            System.out.println("max so far %s, current %s".formatted(maxSoFar, current));
            maxSoFar = Math.max(current, maxSoFar * current);
            
            // Update min product: either start fresh at current element or extend previous min
            System.out.println("min so far %s, current %s".formatted(minSoFar, current));
            minSoFar = Math.min(current, minSoFar * current);

            // Update the global maximum product found so far
            result = Math.max(result, maxSoFar);
            
            // Track global minimum for reference
            result2 = Math.min(result2, minSoFar);
        }

        System.out.println(result2);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, -1, -2, 0};
        System.out.println("Maximum Product: " + maxProduct(arr)); 
        // Output: 6 (from subarray [2, 3])
    }
}


