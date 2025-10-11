package dynamic_programming.top_down;

public class Fib {
    public static int fib(int n, int[] dp){
        if(n <= 1) return n;
        if(dp[n] != -1) return dp[n];
        dp[n] = fib(n -1, dp) + fib(n - 2, dp);
        return dp[n];
    }

    public static void main(String[] args){
        int n = 6;
        int[] dp = new int[n + 1];
        for(int i = 0; i <= n; i++){
            dp[i] = -1;
        }
        System.out.println("Fibonacci of " + n + " is: " + fib(n, dp));
    }
}
