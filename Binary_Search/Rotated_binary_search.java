package Binary_Search;

import java.util.List;

public class Rotated_binary_search {
    private static int search(List<Integer> list, int k){
        int low = 0;
        int high = list.size() - 1;
        int mid = 0;

        while(low <= high ){
            mid = low + (high - low)/2;

            if(list.get(mid) == k) return mid;

            if(list.get(low) <= list.get(mid)){
                if(k >= list.get(low) && k <= list.get(mid)) high = mid - 1;
                else low = mid + 1;
            }else {
                if(k <= list.get(high) && k > list.get(mid)) low = mid + 1;
                else high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        System.out.println( search(List.of(3,4,5,6,1,2),6));
    }
}
