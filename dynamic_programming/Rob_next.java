package dynamic_programming;

import java.util.List;

public class Rob_next {
    private static int maxRob(List<Integer> houses){
        int prev2 = houses.get(0);
        int prev1 = Math.max(prev2, houses.get(1));

        for(int i = 2; i < houses.size(); i++){
            int house = houses.get(i);
            int temp = prev1;
            prev1 = Math.max(prev2 + house, prev1);
            prev2 = temp;
        }

        return prev1;

    }

    public static void main(String[] args){
        System.out.println(maxRob(List.of(5,1, 1, 6)));
    }


}
