package Greedy;

import java.util.List;

public class Far_jump {
    private static boolean canJump(List<Integer> jumps){

        int maxJump = 0;
        for(int i=0; i < jumps.size(); i++){
            if(i>maxJump) return false;

            maxJump = Math.max(maxJump, i + jumps.get(i));
        }

        return true;
    }

    public static void main(String[] args){
        System.out.println(args.length);
        System.out.println(canJump(List.of(2,3,1,1,4)));
    }
}
