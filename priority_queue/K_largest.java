package priority_queue;

import java.util.List;
import java.util.PriorityQueue;

public class K_largest {
    private static int kthLargest(List<Integer> arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i: arr){
            pq.add(i);
            if(pq.size() > k){
                pq.poll();
            }
        }

        return pq.poll();
    }

    public static void main(String[] args){
        System.out.println(kthLargest(List.of(3,2,1,5,6,4), 2));
    }
}
