package backtracking_algo;
// Question 2: Subsets Generation
// Given a set of distinct integers, return all possible subsets (the power set).
// Sample Input:
// nums = [1,2,3]
// Sample Output:
// [[], [1], [2], [3], [1,2], [1,3], [2,3], [1,2,3]]
// Limitations:
// - All elements are distinct
// - Subsets can be in any order
//
// Pseudocode:
// 1. Start with an empty subset.
// 2. For each element, decide to include or exclude it.
// 3. Recursively build subsets by including/excluding each element.
// 4. Add each subset to the result.
// 5. Backtrack after each decision.
//
// Guidance:
// - Use recursion for subset building.
// - Backtrack after each inclusion/exclusion.

import java.util.ArrayList;
import java.util.List;

public class Array_subsets {

    private static List<List<Integer>> subset(List<Integer> arr){
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), arr, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> temp, List<Integer> nums, int start){
        result.add(new ArrayList<>(temp));

        for(int i = start; i < nums.size(); i++){
            temp.add(nums.get(i));
            backtrack(result, temp, nums, i+1);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args){
        System.out.println(subset(List.of(1,2,3,4)));
    }
}

