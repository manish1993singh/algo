package Greedy;

import java.util.List;

public class Gas_station {
    private static int canCompleteCircle(List<Integer> gas, List<Integer> cost){
        
        int total = 0;
        int tank = 0;
        int start = 0;

        for(int i = 0; i < gas.size(); i++){
            int diff = gas.get(i) - cost.get(i);
            total += diff;
            tank += diff;

            if(tank < 0){
                start = i + 1;
                tank = 0;
            }
        }

        return total >= 0 ? start : -1;
    }


    public static void main(String[] args){
        System.out.println(canCompleteCircle(List.of(1,2,3,4,5), List.of(3, 4, 5, 1, 2)));
    }
}
