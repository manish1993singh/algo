package Kadane;

public class MaxProductSubarray {
    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        // Initialize with the first element
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = nums[0];
        int result2 = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            
            /* 
               If the current number is negative, the maximum 
               becomes the minimum and vice versa when multiplied.
            */
            if (current < 0) {
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }

            // Update max and min products ending at the current position
             System.out.println("max so far %s, current %s".formatted(maxSoFar,current));
            maxSoFar = Math.max(current, maxSoFar * current);
            System.out.println("min so far %s, current %s".formatted(minSoFar,current));
            minSoFar = Math.min(current, minSoFar * current);

            // Update the global maximum found so far
            result = Math.max(result, maxSoFar);
            result2 = Math.min(result2, minSoFar);
        }

        System.out.println(result2);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,-1,-2,0};
        System.out.println("Maximum Product: " + maxProduct(arr)); 
        // Output: 6 (from subarray [2, 3])
    }
}

