package priority_queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class K_most_frequent {
    private static List<Integer> mostFrequent(List<Integer> list, int k){
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int i: list){
            countMap.put(i, countMap.getOrDefault(i, 0)+1);
        }
        
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
            (a,b) -> countMap.get(a) - countMap.get(b)
        );

        for(int key: countMap.keySet()){
            priorityQueue.offer(key);
            if(priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }

        int[] result = new int[k];
        for(int i = k - 1; i >= 0; i--){
           result[i] = priorityQueue.poll();
        }

        return Arrays.stream(result).boxed().toList();
    }

    public static void main(String[] args){
        System.out.println(mostFrequent(List.of(1,2,2,3,3,3,4,4,4,4), 2));
    }
}
