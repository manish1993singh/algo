
package dynamic_programming.bottom_up;


public class Knapsack01 {


    /**
     * Solves the 0/1 Knapsack problem using bottom-up dynamic programming.
     * @param itemWeights Array of item weights
     * @param itemValues Array of item values
     * @param maxCapacity Maximum weight capacity of the knapsack
     * @return Maximum value that can be carried in the knapsack
     */
    public static int knapsack(int[] itemWeights, int[] itemValues, int maxCapacity) {
        int itemCount = itemWeights.length;
        // dp[i][w] will hold the max value for first i items and capacity w
        int[][] dp = new int[itemCount + 1][maxCapacity + 1];

        // Build the dp table in bottom-up manner
        int step = 0;
        for (int itemIndex = 0; itemIndex <= itemCount; itemIndex++) {
            for (int currCapacity = 0; currCapacity <= maxCapacity; currCapacity++) {
                step++;
                // Base case: no items or zero capacity
                if (itemIndex == 0 || currCapacity == 0) {
                    dp[itemIndex][currCapacity] = 0;
                    System.out.printf("Step %d: dp[%d][%d] = 0 (base case)\n", step, itemIndex, currCapacity);
                }
                // If the current item's weight is less than or equal to the current capacity
                else if (itemWeights[itemIndex - 1] <= currCapacity) {
                    // Option 1: Include the current item
                    int includeValue = itemValues[itemIndex - 1] + dp[itemIndex - 1][currCapacity - itemWeights[itemIndex - 1]];
                    // Option 2: Exclude the current item
                    int excludeValue = dp[itemIndex - 1][currCapacity];
                    // Take the maximum of including or excluding the item
                    dp[itemIndex][currCapacity] = Math.max(includeValue, excludeValue);
                    System.out.printf("Step %d: dp[%d][%d] = max(include item %d (value=%d, weight=%d) => %d, exclude => %d) = %d\n",
                        step, itemIndex, currCapacity, itemIndex - 1, itemValues[itemIndex - 1], itemWeights[itemIndex - 1], includeValue, excludeValue, dp[itemIndex][currCapacity]);
                }
                // If the current item's weight is more than the current capacity, can't include it
                else {
                    dp[itemIndex][currCapacity] = dp[itemIndex - 1][currCapacity];
                    System.out.printf("Step %d: dp[%d][%d] = dp[%d][%d] (item %d too heavy, weight=%d) = %d\n",
                        step, itemIndex, currCapacity, itemIndex - 1, currCapacity, itemIndex - 1, itemWeights[itemIndex - 1], dp[itemIndex][currCapacity]);
                }
            }
        }

        // Print the final DP table
        System.out.println("\nFinal DP Table:");
        for (int i = 0; i <= itemCount; i++) {
            for (int w = 0; w <= maxCapacity; w++) {
                System.out.printf("%3d ", dp[i][w]);
            }
            System.out.println();
        }

        // The bottom-right cell contains the answer
        return dp[itemCount][maxCapacity];
    }

    public static void main(String[] args) {
        // Example item weights and values
        int[] itemWeights = {3,1,2,4,1,5};
        int[] itemValues = {8,2,3,6,4,8};
        int maxCapacity = 5;

        int maxValue = knapsack(itemWeights, itemValues, maxCapacity);
        System.out.println("Maximum value in knapsack = " + maxValue);
    }
}