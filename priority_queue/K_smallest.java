package priority_queue;

import java.util.Collections;
import java.util.PriorityQueue;

public class K_smallest {
    public static void main(String[] args){
        System.out.println(smallest(new int[]{5,2,8,1,3,0,-1,-4}, 2));
    }

    private static int smallest(int[] list, int k){
        PriorityQueue<Integer> pk = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < list.length; i++){
            pk.add(list[i]);
            if(pk.size() > k){
                pk.poll();
            }
        }
        return pk.poll();
    }
}
