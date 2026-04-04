package hash_map;

import java.util.*;

public class Two_Sum {

    public static int[] twoSum (int[] nums, int target){
        Map<Integer, Integer> numMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(numMap.containsKey(complement)){
                return new int[] {numMap.get(complement), i}; 
            }
            numMap.put(nums[i], i);
        }

        return new int[] {-1, -1}; // return -1 if no solution found
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("Enter the target sum:");
        int target = sc.nextInt();
        sc.close();

        int[] result = twoSum(nums, target);
        if(result[0] != -1){
            System.out.println("Indices of the two numbers that add up to " + target + " are: " + result[0] + " and " + result[1]);
        } else {
            System.out.println("No two numbers add up to " + target);
        }
    }
    
}


//Using this hash map pattern finding the two numbers indicies which will add to give the target number is effecient solution.
//During the iterations, numbers keep getting added in the map along with its index.
//Also during the iterations, current number will be substracted from the target.
//If the remainder is found in the map, algorithm will output the indexes