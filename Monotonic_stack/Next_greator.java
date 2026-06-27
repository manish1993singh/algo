package Monotonic_stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * Next_greator solves the "Next Greater Element" problem using a monotonic stack.
 *
 * Problem:
 * For each element in the input list, find the first greater element to its right.
 * If there is no greater element, return -1 for that position.
 *
 * Example:
 * Input:  [2, 1, 2, 4, 3]
 * Output: [4, 2, 4, -1, -1]
 *
 * Approach:
 * We traverse the list from right to left and keep a stack of candidate values.
 * The stack is monotonic decreasing, so the top of the stack is the next greater
 * element for the current value if one exists.
 */
public class Next_greator {
    private static int[] findNextGreat(List<Integer> list){
        int[] result = new int[list.size()];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = list.size() - 1; i >= 0; i--){
            // Remove smaller or equal elements since they cannot be the next greater
            // element for any earlier position.
            while(!stack.isEmpty() && stack.peek() <= list.get(i)){
                stack.pop();
            }

            // If the stack is empty, there is no greater element to the right.
            result[i] = stack.isEmpty() ? -1 : stack.peek();

            // Push the current element so it can be the next greater element for
            // items to the left.
            stack.push(list.get(i));
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(findNextGreat(List.of(2,1,2,4,3))));
    }
}
