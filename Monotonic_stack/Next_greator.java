package Monotonic_stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Next_greator {
    private static int[] findNextGreat(List<Integer> list){
        int[] result = new int[list.size()];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = list.size() - 1; i >=0; i--){

            while(!stack.isEmpty() && stack.peek() <= list.get(i)){
                stack.pop();
            }

            result[i] = stack.isEmpty()? -1: stack.peek();

            stack.push(list.get(i));
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(findNextGreat(List.of(2,1,2,4,3))));
    }
}
