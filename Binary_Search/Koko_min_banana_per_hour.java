package Binary_Search;

import java.util.List;

public class Koko_min_banana_per_hour {
    
    private static int getMinBananaPerHour(List<Integer> piles, int hours){
        int left = 1; // minimum eating speed is 1
        int right = piles.stream().mapToInt(i -> i).max().orElse(0); // max pile size

        while(left < right){
            int mid = left + (right - left)/2;

            long totalHours = piles.stream().mapToLong(pile -> (long) Math.ceilDiv(pile, mid)).sum();

            if(totalHours <= hours){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args){
        System.out.println(getMinBananaPerHour(List.of(3,6,7,11), 8));
    }
}
