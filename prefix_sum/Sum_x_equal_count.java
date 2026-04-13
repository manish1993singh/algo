package prefix_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sum_x_equal_count {

    private static int getCountOfSubArray(List<Integer> arr, int k){
        int prefSum = 0;
        int count = 0;
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1);

        for(int i = 0; i < arr.size(); i++){
            prefSum += arr.get(i);
            int target = prefSum - k;
            if(prefixMap.containsKey(target)){
                count += prefixMap.get(target);
            }

            prefixMap.put(prefSum, prefixMap.getOrDefault(prefSum, 0) + 1);
        }

        return count;
    }

    private static List<List<Integer>> getSubArrays(List<Integer> arr, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int prefSum = 0;
        
        // Map to store: prefixSum -> List of indices where this sum occurred
        Map<Integer, List<Integer>> prefixMap = new HashMap<>();
        
        // Base case: prefix sum 0 at index -1
        prefixMap.put(0, new ArrayList<>(Arrays.asList(-1)));

        for (int i = 0; i < arr.size(); i++) {
            prefSum += arr.get(i);
            int target = prefSum - k;

            if (prefixMap.containsKey(target)) {
                // For every index where the target sum occurred...
                for (int startIndex : prefixMap.get(target)) {
                    // The subarray is from (startIndex + 1) to i
                    result.add(new ArrayList<>(arr.subList(startIndex + 1, i + 1)));
                }
            }

            // Add the current index to the list for this prefix sum
            prefixMap.computeIfAbsent(prefSum, x -> new ArrayList<>()).add(i);
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println(getCountOfSubArray(List.of(1,0,1), 1));
        System.out.println(getCountOfSubArray(List.of(0,1,0,0), 1));
        System.out.println(getSubArrays(List.of(0,1,0,0), 1));
    }
    
}
