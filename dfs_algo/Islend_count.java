package dfs_algo;

import java.util.ArrayList;
import java.util.List;

public class Islend_count {
    private static int islandCounter(List<List<Integer>> metrix){

        int count = 0;

        for(int r = 0; r < metrix.size(); r++){
            for(int c = 0; c < metrix.get(r).size(); c++){
                if(metrix.get(r).get(c) == 1) {
                    count++;
                    dfs(metrix, r, c);
                }
            }
        }

        return count;
        
    }

    private static void dfs(List<List<Integer>> metrix, int r, int c){
        if(r < 0 || c < 0 || r >= metrix.size() || c >= metrix.get(r).size() || metrix.get(r).get(c) == 0){
            return;
        }

        metrix.get(r).set(c, 0);

        dfs(metrix, r - 1, c);
        dfs(metrix, r, c -1);
        dfs(metrix, r + 1, c);
        dfs(metrix, r, c + 1);
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
