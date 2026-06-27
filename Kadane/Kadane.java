package Kadane;

import java.lang.Math;

/**
 * Simple implementation of Kadane's algorithm.
 *
 * Finds the maximum subarray sum for a given integer array in O(n) time
 * and O(1) extra space. Handles arrays containing all negative numbers
 * by initializing with the first element.
 */
public class Kadane {
    
    /**
     * Compute the maximum subarray sum using Kadane's algorithm.
     *
     * @param arr input array of integers (must be non-empty)
     * @return the largest sum of any contiguous subarray
     *
     * Algorithm notes:
     * - `currentSum` stores the maximum subarray sum that ends at the
     *   current index. For each element we either extend the previous
     *   subarray (`currentSum + arr[i]`) or start a new subarray at
     *   `arr[i]` if that is larger.
     * - `globalSum` keeps the maximum value seen so far across all
     *   `currentSum` values and is returned at the end.
     */
    private int maxOfArray(int[] arr){
        // Start both sums at the first element to correctly handle
        // arrays that contain only negative numbers.
        int globalSum = arr[0];
        int currentSum = arr[0];

        // Iterate through the array once, updating the running sums.
        for(int i = 1; i < arr.length; i++){
            // Decide whether to extend the existing subarray or start
            // a new subarray beginning at arr[i].
            currentSum = Math.max(currentSum + arr[i], arr[i]);

            // Update global maximum if the current running sum is larger.
            globalSum = Math.max(globalSum, currentSum);
        }

        return globalSum;
    }

    public static void main(String[] args){
        int[] intput1 = new int[]{1, 2, 3, -1};
        int[] input2 = new int[]{-1, -2, -3, -4};
        int[] input3 = new int[]{-1, 2, 3, -4};
        int[] input4 = new int[]{-1, 2, 3, -3, 1, 6, -7, 1, 2};
        int[] input5 = new int[]{-1,5};

        Kadane kadane = new Kadane();
        // System.out.println(kadane.maxOfArray(intput1));
        // System.out.println(kadane.maxOfArray(input2));
        // System.out.println(kadane.maxOfArray(input3));
        System.out.println(kadane.maxOfArray(input5));


    }
}
