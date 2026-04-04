package prefix_sum;
import java.util.ArrayList;
import java.util.List;

public class Sum_x_greator_or_equal {

    private static int count(List<Integer> arr, int k){
        int count = 0;
        int prefixSum = 0;

        List<Integer> sortedPrefixList = new ArrayList<>();

        sortedPrefixList.add(0);

        for(int i: arr){
            prefixSum += i;
            int target = prefixSum - k;

            int index = findFirstGreatestOrEqual(sortedPrefixList, target);
            count += sortedPrefixList.size() - index;

            int insertPos = findFirstGreatestOrEqual(sortedPrefixList, prefixSum);
            sortedPrefixList.add(insertPos, prefixSum);
        }

        return count;
    
    }

    

    private static int findFirstGreatestOrEqual(List<Integer> list, int value){
        int low = 0;
        int high = list.size();
        while(low < high){
            int mid = low + (high - low)/2;
            if(list.get(mid) < value) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    public static void main(String[] args){
        List<Integer> input1 = List.of(1,-1, 2, 3);
        int k1 = 3;
        System.out.println(count(input1, k1));
    }
}
//solved with prefix sum and a sorted arry solution.
//prefix sum because the input will have -ve values.
//Sorted array is used to reduce the time complexity 