package heap;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class Median_in_stream {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public Median_in_stream(){
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    private void add(int num){
        maxHeap.offer(num);

        minHeap.offer(maxHeap.poll());

        if(minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    private int findMedian(){
        if(maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
        }

        return (maxHeap.peek()+minHeap.peek())/2;
    }

    public static void main(String[] args){
        Median_in_stream median_in_stream = new Median_in_stream();

        for(int num: new int[]{5,15,1,3}){
            median_in_stream.add(num);
            System.out.println(median_in_stream.findMedian());
        }
    }
}
