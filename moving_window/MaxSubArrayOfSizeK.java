package moving_window;

import java.util.*;

public class MaxSubArrayOfSizeK {

    public static int maxSumSubarray(int[] arr, int k){
        int maxSum = 0, windowSum = 0;
        for(int i = 0; i< k; i++){
            windowSum += arr[i];
        }
        maxSum = windowSum;
        for(int right = k; right < arr.length; right++){
            windowSum += arr[right] - arr[right - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    public static void main(String[] args){
        //update the code to read the array and k from user input in one line
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        // int n = sc.nextInt();
        // int[] arr = new int[n];
        // System.out.println("Enter the elements of the array:");
        // for(int i = 0; i < n; i++){
        //     arr[i] = sc.nextInt();
        // }
        // System.out.println("Enter the size of the subarray:");
        // int k = sc.nextInt();
        // sc.close();
        //read comma separated integers in one line
        String input = sc.nextLine();
        String[] inputs = input.split(",");
        int[] arr = new int[inputs.length];
        for(int i = 0; i < inputs.length; i++){
            arr[i] = Integer.parseInt(inputs[i].trim());
        }
        System.out.println("Enter the size of the subarray:");
        int k = sc.nextInt();
        sc.close();

        System.out.println("Maximum sum of a subarray of size " + k + " is: " + maxSumSubarray(arr, k));
    }
}


//Maximum sum of sub array problem is solved with moving two pointers window.
//For the given array and the window size, first total sum is generated.
//Then the window moves one index at at time towards right edge.
//It recomputes the total
//It compares and picks the maxmum.