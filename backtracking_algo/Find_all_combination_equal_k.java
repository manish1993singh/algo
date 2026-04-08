package backtracking_algo;

import java.util.ArrayList;
import java.util.List;

public class Find_all_combination_equal_k {

    private static List<List<Integer>> findCombinations(List<Integer> list, int target){
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), list, target, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> temp, List<Integer> list, int remaining, int start){
        if(remaining == 0){
            result.add(new ArrayList<>(temp));
            return;
        }

        if(remaining < 0){
            return;
        }

        for(int i = start; i < list.size(); i++){
            temp.add(list.get(i));
            backtrack(result, temp, list, remaining - list.get(i), i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<Integer> input = List.of(2, 3, 5, 6, 7);
        int target = 7;

        List<List<Integer>> combinations = findCombinations(input, target);

        System.out.println("Input: " + input);
        System.out.println("Target: " + target);
        System.out.println("All combinations that sum to target:");
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
}

