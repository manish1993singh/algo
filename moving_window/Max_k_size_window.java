package moving_window;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//Given an array, find the maximum element in every window of size k.
public class Max_k_size_window {
    public static ArrayList<Integer> getMaxList(List<Integer> list, int k){

        int size = list.size();
        Deque<Integer> deque = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<Integer>();

        for(int i = 0; i < size; i++){
            //remove indices outside the window
            if(!deque.isEmpty() && deque.peekFirst() < i - k + 1) deque.pollFirst();
            //remove indices with smaller value
            while(!deque.isEmpty() && list.get(deque.peekLast()) < list.get(i)) deque.pollLast();
            //add current index
            deque.offerLast(i);
            //maximum is at front
            if(i > k - 1) result.add(list.get(deque.peekFirst()));
        }
        
        return result;
    }

    public static void main(String[] args){
        List<Integer> input1 = List.of(1,5,2,1,1);
        System.out.println(getMaxList(input1, 3));
    }
}
