package prefix_sum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sum_x_equal_min_len_sub_array {
    
    private static int getMinLength(List<Integer> arr, int x){

        int prefixSum = 0;
        int minLength = Integer.MAX_VALUE;
        Map<Integer, Integer> prefixMap = new HashMap<>();

        for(int i = 0; i < arr.size(); i++){
            prefixSum += arr.get(i);
            int target = prefixSum - x;

            if(prefixMap.containsKey(target)){
                System.out.println(target);
                minLength = Math.min(minLength, i - prefixMap.get(target));
            }

            System.out.println("Prefix sum:"+prefixSum);

            prefixMap.put(prefixSum, i);
        }

        System.out.println(prefixMap);

        return minLength;
    }

    public static void main(String[] args){
        System.out.println(getMinLength(List.of(1,-1, 5, -2, 3), 3));
    }
}
