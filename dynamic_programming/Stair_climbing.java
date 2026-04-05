package dynamic_programming;

public class Stair_climbing {
    
    private static int getNumberOfWays(int staris){
        int prev2 = 1;
        int prev1 = 2;

        for(int i = 3; i <= staris; i++){
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args){
        System.out.println(getNumberOfWays(5));
    }
}
