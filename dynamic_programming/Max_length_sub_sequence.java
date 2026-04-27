package dynamic_programming;

import java.util.Arrays;
import java.util.List;

public class Max_length_sub_sequence {
    private static int getMaxlengethSubSequence(List<Integer> list){

        if(list.size() <= 0) return 0;
        int[] dp = new int[list.size()];
        Arrays.fill(dp,1);
        int maxLIS = 1;

        for(int i = 1; i < list.size(); i++){
            for(int j = 0; j < i; j++){
                if(list.get(j) < list.get(i)){
                    dp[i] = Math.max(dp[i], dp[j] +1);
                }
            }
            maxLIS = Math.max(maxLIS, dp[i]);
        }

        return maxLIS;
    }

    public static void main(String[] args){
        System.out.println(getMaxlengethSubSequence(List.of(10, 9, 2, 5, 3, 7, 101, 18)));
    }
}
