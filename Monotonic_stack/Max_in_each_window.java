package Monotonic_stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// This class solves the Sliding Window Maximum problem.
// Given an array of integers and a window size k, it returns an array
// containing the maximum value in each sliding window of size k.
// The algorithm uses a monotonic deque to maintain the maximum efficiently
// in O(n) time complexity.
public class Max_in_each_window {
    public static int[] getMaxInEachWindow(int[] list, int k){

        Deque<Integer> maxDeque = new ArrayDeque<>();
        int[] result = new int[list.length - k + 1];

        for(int i = 0; i < list.length; i++){
            // Remove indices that are out of the current window (i - k)
            while(!maxDeque.isEmpty() && maxDeque.peekFirst() <= i - k){
                maxDeque.pollFirst();
            }

            // Remove elements from the back that are smaller than the current element
            // to maintain a decreasing order in the deque
            while(!maxDeque.isEmpty() && list[maxDeque.peekLast()] < list[i]){
                maxDeque.pollLast();
            }

            // Add the current index to the back of the deque
            maxDeque.addLast(i);

            // Once we have processed at least k elements, record the maximum
            // which is at the front of the deque
            if(i >= k - 1){
                result[i - k + 1] = list[maxDeque.peekFirst()];
            }
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getMaxInEachWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
    }

}
