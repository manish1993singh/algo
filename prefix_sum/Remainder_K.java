package prefix_sum;

import java.util.List;

public class Remainder_K {
    private static int findSubArray(int[] list, int k){
        int prefixSum = 0;
        int[] remainderCount  = new int[k];
        remainderCount [0] = 1;
        int count =0;

        for(int num:list){
            prefixSum += num;

            int remainder = ((prefixSum % k)+k)%k;

            count += remainderCount[remainder];

            remainderCount[remainder]++;
        }

        return count;
    }

    public static void main(String[] args){
        System.out.println(findSubArray(new int[]{4,5,0,-2,-3,1}, 5));
    }
}
