package dynamic_programming;

import java.util.Arrays;

public class Split_array_equal_sum {
    private static boolean canSplitInEqualSumSubArray(int[] list){
        int sum = Arrays.stream(list).reduce(0, (a,b)-> a+b);

        int remainder =  sum%2;
        if(remainder > 0) return false;

        int half = sum/2;

        boolean[] usedNumber = new boolean[half+1];
        usedNumber[0] = true;

        for(int num: list){

            for(int i = half; i >= num; i--){
                usedNumber[i] = usedNumber[i - num];
                if(usedNumber[half]) return true;
            }
        }

        if(usedNumber[half]) return true;

        return false;

    }

    public static void main(String[] args){
        System.out.println(canSplitInEqualSumSubArray(new int[]{1,5,11,5}));
    }
}
