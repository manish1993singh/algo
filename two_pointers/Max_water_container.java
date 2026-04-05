package two_pointers;

import java.util.List;

public class Max_water_container {
    
    private static int getMaxCapicityContainer(List<Integer> space){
        int left = 0;
        int right = space.size() - 1;
        int maxCapacity = 0;
        while(left < right){
            int capacity = Math.min(space.get(left), space.get(right))*(right - left);
            maxCapacity = Math.max(maxCapacity, capacity);
            if(space.get(left) <= space.get(right)){
                left++;
            }else {
                right--;
            }
        }
        return maxCapacity;
    }

    public static void main(String[] args){
        System.out.println(getMaxCapicityContainer(List.of(1,8,6,2,5,4,8,3,7)));
    }
}
