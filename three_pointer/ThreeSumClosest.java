package three_pointer;

import java.util.*;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize with the first three elements

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum; // Update closest sum if current is closer to target
                }

                if (currentSum < target) {
                    left++; // Move left pointer to increase sum
                } else if (currentSum > target) {
                    right--; // Move right pointer to decrease sum
                } else {
                    return currentSum; // Exact match found
                }
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        int[] nums = {-1, -2, 1, -4};
        int target = -3;
        System.out.println("The sum that is closest to the target " + target + " is: " + threeSumClosest(nums, target));
    }
}
