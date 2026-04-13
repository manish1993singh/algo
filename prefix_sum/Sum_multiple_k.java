package prefix_sum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sum_multiple_k {
    
    private static boolean isSumMultipleOfK(List<Integer> list, int k, int n){
        Map<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, 1);

        int runningSum = 0;

        for(int i = 0; i < list.size(); i++){
            runningSum += list.get(i);
            int remainder = (k == 0)? runningSum: runningSum%k;

            if(remainderMap.containsKey(remainder)){
                if(i - remainderMap.get(remainder) >= n){
                    return true;
                }
            }else{
                remainderMap.put(remainder, i);
            }
        }

        return false;
    }

    public static void main(String[] args){
        System.out.println(isSumMultipleOfK(List.of(23,2,4,6,7), 6, 2));
    }
}
