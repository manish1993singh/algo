package Monotonic_stack;

import java.util.Stack;

public class Sum_min_all_subarray {
    private static long sumMinAllSubarray(int[] arr){
        int[] leftMin = new int[arr.length];
        int[] rightMin = new int[arr.length];
        long mod = (long) 1e9 + 7;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < arr.length; i++){
            while(!stack.empty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }

            leftMin[i] = stack.empty()? -1: stack.peek();

            stack.push(i);
        }

        stack.clear();

        for(int i = arr.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }

            rightMin[i] = stack.isEmpty()? arr.length: stack.peek();

            stack.push(i);
        }

        long totalSum = 0;
        for(int i = 0; i < arr.length; i++){
            long total = (long)(i - leftMin[i]) * (rightMin[i] - i);

            totalSum = (totalSum + (total * arr[i]));
        }

        return totalSum;
    }

    public static void main(String[] args){
        System.out.println(sumMinAllSubarray(new int[]{3,1,2,4}));
    }
}
