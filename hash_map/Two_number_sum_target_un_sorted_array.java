package hash_map;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Two_number_sum_target_un_sorted_array {
    public static boolean twoSum(int[] arr, int target){
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i: arr){
            int neededValue = target - i;
            if(map.containsKey(neededValue)) return true;
            map.put(i, true);
        }
        return false;
    }

    public static int[] twoSumIndex(int[] arr, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int neededValue = target - arr[i];
            if(map.containsKey(neededValue)) return new int[]{map.get(neededValue), i};
            map.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }

    public static int[] twoSumValues(int[] arr, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int neededValue = target - arr[i];
            if(map.containsKey(neededValue)) return new int[]{map.get(neededValue), arr[i]};
            map.put(arr[i], arr[i]);
        }
        return new int[]{-1, -1};
    }

    public static List<List<Integer>> twoSumAllSets(int[] arr, int target){
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            int neededValue = target - arr[i];
            if(map.containsKey(neededValue)) result.add( Arrays.asList(map.get(neededValue), arr[i]));
            map.put(arr[i], arr[i]);
        }
        return result;
    }

    public static void main(String[] args){
        int[] arr = new int[]{1, 2, 3, 4, 5,8};
        int target = 9;
        System.out.println(twoSum(arr, target));
        System.out.println("Indices: " + Arrays.toString(twoSumIndex(arr, target)));
        System.out.println("Values: " + Arrays.toString(twoSumValues(arr, target)));
        System.out.println("All Sets: " + twoSumAllSets(arr, target));

        int[] arr2 = new int[]{1, 2, 3, 4, 5};
        int target2 = 10;
        System.out.println(twoSum(arr2, target2));
        System.out.println("Indices: " + Arrays.toString(twoSumIndex(arr2, target2)));
        System.out.println("Values: " + Arrays.toString(twoSumValues(arr2, target2)));
        System.out.println("All Sets: " + twoSumAllSets(arr2, target2));

        int[] arr3 = new int[]{1, 2, 3, 4, 5};
        int target3 = 8;
        System.out.println(twoSum(arr3, target3));
        System.out.println("Indices: " + Arrays.toString(twoSumIndex(arr3, target3)));
        System.out.println("Values: " + Arrays.toString(twoSumValues(arr3, target3)));
        System.out.println("All Sets: " + twoSumAllSets(arr3, target3));

        int[] arr4 = new int[]{5,-1, 2, 3, 5};
        int target4 = 4;
        System.out.println(twoSum(arr4, target4));
        System.out.println("Indices: " + Arrays.toString(twoSumIndex(arr4, target4)));
        System.out.println("Values: " + Arrays.toString(twoSumValues(arr4, target4)));
        System.out.println("All Sets: " + twoSumAllSets(arr4, target4));
    }
}
