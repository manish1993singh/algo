package prefix_sum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sum_x_equal_max_len_sub_array {
    private static int getSubArray(List<Integer> arr, int x){

        int prefixSum = 0;
        int maxLength = 0;
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, -1);

        for(int i=0; i< arr.size(); i++){
            prefixSum += arr.get(i);

            int target = prefixSum - x;

            if(prefixMap.containsKey(target)){
                maxLength = Math.max(maxLength, i - prefixMap.get(target));
            }

            prefixMap.putIfAbsent(prefixSum, i);
        }

        return maxLength;
    }

    public static void main(String[] args){
        List<Integer> input1 = List.of(1, -1, 5, -2, 3);
        System.out.println(getSubArray(input1, 3));
    }
}
