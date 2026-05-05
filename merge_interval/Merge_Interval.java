package merge_interval;

import java.util.Arrays;
import java.util.LinkedList;

public class Merge_Interval {
    private static int[][] mergeInterval(int[][]intervals){
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));

        LinkedList<int[]> merged = new LinkedList<>();

        for(int[] interval: intervals){
            if(merged.isEmpty() || merged.getLast()[1] < interval[0]){
                merged.add(interval);
            }else{
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args){
        int[][] input = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = mergeInterval(input);
        
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
