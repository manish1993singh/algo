package prefix_sum;

/**
 * Find the number of subarrays whose sum is divisible by k.
 *
 * Question:
 * Given an array of integers and an integer k, count how many contiguous
 * subarrays have a sum that is divisible by k. For example, with array
 * [4, 5, 0, -2, -3, 1] and k = 5, we need to count all subarrays whose
 * sum % k == 0.
 *
 * Solution:
 * 
 * 1. Understanding Prefix Sums:
 *    A prefix sum P[i] is the cumulative sum of elements from index 0 to i.
 *    For a subarray from index i+1 to j:
 *    Subarray Sum = P[j] - P[i]
 *
 * 2. The Modular Arithmetic Rule:
 *    For a subarray sum to be divisible by k, its remainder must be 0:
 *    (P[j] - P[i]) mod k = 0
 *    
 *    This is only possible if both prefix sums have the same remainder:
 *    P[j] mod k = P[i] mod k
 *
 * 3. Algorithm:
 *    Track remainder frequencies as you compute prefix sums.
 *    For each element, calculate the current prefix sum remainder and check
 *    how many previous prefix sums share the same remainder—each match
 *    represents a valid subarray divisible by k.
 *
 * Time complexity: O(n), where n is the array length.
 * Space complexity: O(k) for the remainder count array.
 */
public class Remainder_K {
    private static int findSubArray(int[] list, int k){
        int prefixSum = 0;
        int[] remainderCount  = new int[k];
        remainderCount [0] = 1;
        int count =0;

        for(int num:list){
            prefixSum += num;

            int remainder = ((prefixSum % k)+k)%k;

            count += remainderCount[remainder];

            remainderCount[remainder]++;
        }

        return count;
    }

    public static void main(String[] args){
        System.out.println(findSubArray(new int[]{4,5,0,-2,-3,1}, 5));
    }
}

// This problem is a classic example of how a seemingly complex nested-loop problem can be optimized into a single pass using **Prefix Sums**, **Modular Arithmetic**, and **Combinatorics**.

// Here is the complete, high-level blueprint of how all these concepts fit together perfectly. You can use this as a quick-reference guide whenever you need to refresh your memory.

// ---

// ## 1. The Core Trick: Prefix Sums

// Instead of calculating the sum of every subarray from scratch, we look at the running totals from the beginning of the array (called **Prefix Sums**).

// The fundamental rule of prefix sums is:

// > The sum of any subarray between index $i$ and index $j$ is simply:
// > 
// > $$\text{Subarray Sum} = \text{PrefixSum}[j] - \text{PrefixSum}[i-1]$$
// > 
// > 

// ---

// ## 2. The Bridge: Modular Arithmetic

// We want to know if a subarray sum is divisible by $k$. In math terms, this means its remainder when divided by $k$ must be `0`:


// $$(\text{PrefixSum}[j] - \text{PrefixSum}[i-1]) \pmod k = 0$$

// If we rewrite this equation, it tells us something amazing:


// $$\text{PrefixSum}[j] \pmod k = \text{PrefixSum}[i-1] \pmod k$$

// **The Takeaway:** You don't need to calculate the actual subarray sums. If two points in your prefix timeline share the **exact same remainder**, the numbers between them *automatically* add up to a multiple of $k$.

// ---

// ## 3. The Counter: Combinatorics (Handshakes)

// Because any pair of matching remainders creates a valid subarray, the problem shifts from a searching problem to a counting problem.

// If a specific remainder appears $n$ times throughout your timeline, how many unique pairs can you form from those $n$ points? Order doesn't matter (Point A to Point B is the same subarray as Point B to Point A), so we use the standard combination formula for choosing pairs:


// $$\text{Total Pairs} = \frac{n \times (n - 1)}{2}$$

// ---

// ## 4. How the Two Code Approaches Do This Math

// Your code handles this counting in one of two ways—both mathematically identical, just executed at different times.

// ### Approach A: The Rolling Sum (Your `for` loop shortcut)

// Inside your loop, you have these lines:

// ```java
// count += result[remainder];
// result[remainder]++;

// ```

// Instead of waiting until the end, this calculates the pairs progressively. Every time a remainder appears, it looks back at how many matching remainders came before it (`result[remainder]`) and instantly pairs up with all of them.

// * The 1st time it sees a remainder: It adds `0` to count, then stores `1`.
// * The 2nd time: It adds `1` to count, then stores `2`.
// * The 3rd time: It adds `2` to count, then stores `3`.

// This naturally builds the arithmetic series: $0 + 1 + 2 + \dots + (n-1)$, which algebraically evaluates exactly to $\frac{n(n-1)}{2}$.

// ### Approach B: The Final Array Batch (Your `stream` reduction)

// At the end of your code, you use:

// ```java
// return Arrays.stream(result)
//              .map(c -> (c * (c - 1)) / 2)
//              .sum();

// ```

// This bypasses the rolling count completely. It lets the loop finish until the frequency table (`result`) holds the final total frequencies ($n$) for every remainder. Then, it cleanly applies the explicit combination formula $\frac{n(n-1)}{2}$ to each group and adds them up.

// ---

// ## 5. Summary Cheat Sheet

// | Concept | What it solves | The Code Formula |
// | --- | --- | --- |
// | **Prefix Sum** | Eliminates the need to look at subarrays individually. | `prefixSum += list[i]` |
// | **Java Modulo** | Keeps remainders positive and safe for array indices. | `((sum % k) + k) % k` |
// | **Base Case** | Accounts for subarrays that start exactly at index 0. | `result[0] = 1` |
// | **Combinations** | Counts how many pairs can be formed from matching remainders. | $\frac{n(n-1)}{2}$ |
