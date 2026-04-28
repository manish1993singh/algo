package Binary_Search;

/**
 * This class solves the problem of splitting an array into k subarrays
 * such that the maximum sum of any subarray is minimized.
 *
 * Problem: Given an array of integers and an integer k, split the array
 * into k contiguous subarrays such that the maximum sum among all subarrays
 * is as small as possible.
 *
 * Approach: Use binary search on the possible maximum sum values.
 * The minimum possible maximum sum will be at least the largest element
 * and at most the total sum of the array.
 */
public class Array_split {

    /**
     * Finds the minimum possible maximum sum when splitting the array into k subarrays.
     *
     * @param list the input array of integers
     * @param k the number of subarrays to split into
     * @return the minimum possible maximum sum of any subarray
     */
    private static int getSplit(int[] list, int k){
        int low = 0;  // Minimum possible max sum (at least the largest element)
        int high = 0; // Maximum possible max sum (total sum of array)
        int ans = 0;  // Will store the answer

        // Calculate low and high bounds
        for(int num:list){
            low = Math.min(low, num);  // low is the maximum element in the array
            high += num;               // high is the sum of all elements
        }
        ans = high;  // Initialize answer to the maximum possible

        // Binary search for the minimum possible maximum sum
        while(low <= high){
            int mid = low + (high - low)/2;  // Mid value to test

            if(canSplit(list, k, mid)){  // If we can split with max sum <= mid
                ans = mid;               // Update answer
                high = mid - 1;          // Try smaller sums
            }else{
                low = mid + 1;           // Need larger sums
            }
        }

        return ans;
    }

    /**
     * Checks if it's possible to split the array into k subarrays
     * where no subarray sum exceeds the given high value.
     *
     * @param list the input array
     * @param k the number of subarrays allowed
     * @param high the maximum allowed sum for any subarray
     * @return true if splitting is possible, false otherwise
     */
    private static boolean canSplit(int[] list, int k, int high){
        int subArray = 1;      // Start with 1 subarray
        int subArraySum = 0;   // Current sum of the current subarray

        for (int num : list) {
            if(subArraySum + num > high){  // If adding num exceeds high
                subArray++;                // Start a new subarray
                subArraySum = num;         // Reset sum to current num
                if(subArray > k) return false;  // Too many subarrays needed
            }else{
                subArraySum += num;        // Add to current subarray
            }
        }

        return true;  // Successfully split into <= k subarrays
    }


    public static void main(String[] args){
        // Example: Split [7,2,5,10,8] into 2 subarrays with minimum maximum sum
        System.out.println(getSplit(new int[]{7,2,5,10,8}, 2));
    }
}
