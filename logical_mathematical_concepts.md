Here is a curated list of **10 fundamental, concept-focused problems** frequently asked in modern interviews. Each problem focuses on a specific mathematical or logical blueprint that allows you to optimize a slow, brute-force solution into an efficient $O(N)$ or $O(\log N)$ solution.

---

### 1. Two Sum (The Complement Lookup)

- **The Concept:** Using a Hash Map to find a "complement" value in $O(1)$ time instead of nested loops.
- **Problem:** Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to `target`.
- **The Blueprint:** Instead of checking every pair, iterate through the array. For each number $x$, check if $(\text{target} - x)$ already exists in your map. If not, throw $x$ into the map and keep moving.

### 2. Maximum Subarray / Kadane's Algorithm (The Local Reset)

- **The Concept:** Dynamic Programming / Optimization over a stream. Deciding whether to join an existing streak or start a fresh one.
- **Problem:** Find the contiguous subarray which has the largest sum and return its sum.
- **The Blueprint:** At any element $x$, the maximum sum ending at this position is either $x$ itself, or $x$ added to the previous maximum subarray sum. If the previous sum drops below 0, you "reset" and start a new subarray from $x$.

### 3. Product of Array Except Self (Prefix & Suffix Accumulation)

- **The Concept:** Constructing a result by multiplying all elements before it (Prefix) and all elements after it (Suffix) without using the division operator.
- **Problem:** Given an integer array `nums`, return an array `answer` such that `answer[i]` is equal to the product of all the elements of `nums` except `nums[i]`.
- **The Blueprint:** Loop forward to calculate a running product of everything to the left of `i`. Then, loop backward to multiply it by a running product of everything to the right of `i`.

### 4. Merge Intervals (Sorting & Boundary Tracking)

- **The Concept:** Sorting data to reduce a complex multi-way comparison into a simple, linear comparison with the "most recent" state.
- **Problem:** Given an array of intervals where `intervals[i] = [start, end]`, merge all overlapping intervals.
- **The Blueprint:** Sort the intervals by their start times. Iterate through them: if the current interval's start time is less than or equal to the previous interval's end time, they overlap—merge them by updating the previous interval's end time to the maximum of both.

### 5. Missing Number (Bit Manipulation / XOR / Arithmetic Series)

- **The Concept:** Using mathematical invariants (like Gauss's formula or XOR properties) to find a missing element in a single pass without extra memory.
- **Problem:** Given an array `nums` containing $n$ distinct numbers in the range `[0, n]`, return the only number in the range that is missing from the array.
- **The Blueprint:** Calculate the expected sum of numbers from $0$ to $n$ using $\frac{n(n+1)}{2}$. Subtract the sum of the actual elements in the array from that expected sum; the remainder is your missing number.

### 6. Subarray Sum Equals K (Prefix Sum + Frequency Map)

- **The Concept:** Combining prefix sums with a Hash Map to find a target _difference_ (very similar to the problem you just mastered, but looking for an exact difference instead of a divisibility match).
- **Problem:** Given an array of integers `nums` and an integer `k`, return the total number of subarrays whose sum equals `k`.
- **The Blueprint:** Track a running `prefixSum`. At each step, check your map to see how many times a prefix sum equal to `(prefixSum - k)` has appeared in the past. Add that count to your total, then store the current `prefixSum` in the map.

### 7. Container With Most Water (Two-Pointer Convergence)

- **The Concept:** Shrinking a search space from both ends by squeezing the pointer that limits your maximum potential.
- **Problem:** Given $n$ non-negative integers representing heights of lines, find two lines that together with the x-axis forms a container that holds the most water.
- **The Blueprint:** Place one pointer at the start and one at the end. Calculate the area (width $\times$ minimum height of the two lines). To find a larger area, you must move the pointer that points to the _shorter_ line inward, because the shorter line acts as the bottleneck.

### 8. Single Number (XOR Cancellation)

- **The Concept:** The unique property of XOR: $A \oplus A = 0$ and $A \oplus 0 = A$. Duplicates cancel each other out completely.
- **Problem:** Given a non-empty array of integers `nums`, every element appears twice except for one. Find that single one.
- **The Blueprint:** XOR all the numbers in the array together into a single variable. The pairs will perfectly clear each other to 0, leaving only the unique single number behind.

### 9. Pow(x, n) (Binary Exponentiation / Divide and Conquer)

- **The Concept:** Reducing $O(N)$ operations to $O(\log N)$ by squaring the base and halving the exponent at each step.
- **Problem:** Implement `pow(x, n)`, which calculates $x$ raised to the power $n$.
- **The Blueprint:** If you want to compute $2^{10}$, instead of multiplying 2 ten times, compute $(2^2)^5 = 4^5$. If the exponent is odd, pull one base out ($4 \times 4^4$) and continue halving the exponent.

### 10. Counting Bits (Pattern Recognition / Bit Shifting)

- **The Concept:** Using a previously calculated sub-problem state (DP) coupled with binary bit-shifting (`>> 1`).
- **Problem:** Given an integer `n`, return an array of length `n + 1` such that for each `i`, `ans[i]` is the number of 1 bits in the binary representation of `i`.
- **The Blueprint:** The number of set bits in $i$ is exactly equal to the number of set bits in $i / 2$ (which is `i >> 1`), plus $1$ if $i$ is an odd number (`i % 2`). This lets you build the entire answer array sequentially in $O(1)$ time per number.
