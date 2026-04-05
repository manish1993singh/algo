package bfs_algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Islend_count {

    private static int islandCounter(List<List<Integer>> metric){
        int count = 0;

        for(int r = 0; r < metric.size(); r++){
            for(int c = 0; c < metric.get(0).size(); c++){
                if(metric.get(r).get(c) == 1){
                    count++;
                    bfs(metric, r, c);
                }
            }
        }

        return count;
    }

    private static void bfs(List<List<Integer>> metric, int r, int c){
        Queue<List<Integer>> queue = new LinkedList<>();

        queue.offer(List.of(r, c));

        metric.get(r).set(c, 0);

        List<List<Integer>> direction = List.of(List.of(-1, 0), List.of(1, 0), List.of(0, -1), List.of(0,1));

        while(!queue.isEmpty()){
            List<Integer> cell = queue.poll();
            for(List<Integer> d: direction){
                int nr = cell.get(0) + d.get(0);
                int nc = cell.get(1) + d.get(1);

                if(nr >= 0 && nc >= 0 && nr < metric.size() && nc < metric.get(nr).size() && metric.get(nr).get(nc) == 1){
                    metric.get(nr).set(nc, 0);
                    queue.offer(List.of(nr, nc));
                }

            }
        }
    }
    

    public static void main(String[] args){

        List<List<Integer>> metric = new ArrayList<>();
        metric.add(new ArrayList<>(List.of(1,1,0,0)));
        metric.add(new ArrayList<>(List.of(1,1,0,0)));
        metric.add(new ArrayList<>(List.of(0,0,1,0)));
        metric.add(new ArrayList<>(List.of(0,0,0,1)));
        System.out.println(islandCounter(metric));
    }
}
