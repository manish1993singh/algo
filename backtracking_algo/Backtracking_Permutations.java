package backtracking_algo;

import java.util.ArrayList;
// Question: Generate all permutations of a list of distinct numbers
// Given a list of distinct integers, return all possible permutations.
// Sample Input:
// nums = [1, 2, 3]
// Sample Output:
// [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
// Limitations:
// - All elements are distinct
// - Each arrangement must use all numbers exactly once
//
// Pseudocode:
// 1. Start with an empty arrangement.
// 2. For each unused number, add it to the arrangement.
// 3. Recursively build arrangements by including each unused number.
// 4. If arrangement length equals input length, add to result.
// 5. Backtrack after each inclusion.
//
// Guidance:
// - Use recursion to build arrangements.
// - Use a boolean array or set to track used numbers.
// - Backtrack after each recursive call to explore other possibilities.
import java.util.List;

public class Backtracking_Permutations {
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPermutation = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, currentPermutation, result);

        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> currentPermutation, List<List<Integer>> result){
        //Base case: if current permutation is completed, add a copy to result
        if(currentPermutation.size() == nums.length){
            result.add(new ArrayList<>(currentPermutation));
            return;
        }
        for(int i = 0 ; i < nums.length; i++){
            if(!used[i]){
                used[i] = true;
                currentPermutation.add(nums[i]);
                backtrack(nums, used, currentPermutation, result);

                currentPermutation.remove(currentPermutation.size() - 1);
                used[i] = false;
            }
        }

    }
    
    public static void main(String[] args){
        Backtracking_Permutations backtracking_Permutations = new Backtracking_Permutations();
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = backtracking_Permutations.permute(nums);
        System.out.println("All permutations:"+permutations);

    }
}
