package prefix_sum;

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

            prefixMap.put(prefSum, prefixMap.getOrDefault(target, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args){
        System.out.println(getCountOfSubArray(List.of(1,0,1), 1));
    }
    
}
