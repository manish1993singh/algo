package Kadane;

import java.lang.Math;

public class Kadane {
    
    private int maxOfArray(int[] arr){
        int globalSum = arr[0];
        int currentSum = arr[0];

        for(int i = 1; i < arr.length; i++){
            currentSum = Math.max(currentSum + arr[i], arr[i]);
            globalSum = Math.max(globalSum, currentSum);
        }

        return globalSum;
    }

    public static void main(String[] args){
        int[] intput1 = new int[]{1, 2, 3, -1};
        int[] input2 = new int[]{-1, -2, -3, -4};
        int[] input3 = new int[]{-1, 2, 3, -4};
        int[] input4 = new int[]{-1, 2, 3, -4, 5, 6, -7, 8, 9};

        Kadane kadane = new Kadane();
        System.out.println(kadane.maxOfArray(intput1));
        System.out.println(kadane.maxOfArray(input2));
        System.out.println(kadane.maxOfArray(input3));
        System.out.println(kadane.maxOfArray(input4));


    }
}
