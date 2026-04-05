Good—this is exactly how a senior engineer trains pattern recognition: **repetition + structured thinking + explicit triggers**.

I’ll give you **5 problems**, each targeting a **different core pattern**. Read them aloud slowly—this will sharpen both thinking and communication.

---

# ✅ Problem 1 — Sliding Window + Prefix Sum Hybrid

## 1. Problem

**Maximum Size Subarray Sum Equals k**

Find the maximum length of a subarray that sums to `k`.

---

## 2. Input

```
nums = [1, -1, 5, -2, 3]
k = 3
```

---

## 3. Output

```
4
```

---

## 4. Deep Breakdown

- Array contains **positive + negative numbers**
- We need **maximum length**
- Constraint signal:
  - Sliding window **fails with negatives**
  - Prefix sum becomes important

### Why brute force fails:

- O(n²) subarrays → too slow for large input

### Tricky Part:

- You cannot shrink window reliably because **sum is not monotonic**

### Trigger Moment:

> “Wait… I need sum of subarray = k → prefix sum difference”

---

## 5. Pattern Identification

- ✅ **Pattern: Prefix Sum + HashMap**

- Why:
  - If `prefixSum[j] - prefixSum[i] = k`
  - Then subarray `(i+1 → j)` is valid

- ❌ Sliding window fails (negative numbers break it)

---

## 6. Step-by-Step Thought Process

- Track cumulative sum
- Store first occurrence of each prefix sum
- At each index:
  - Check: `currentSum - k` exists?

> “At this point, I realize this is prefix sum because I need subarray sum in O(1) lookup”

---

## 7. Code (Java)

```java
public int maxSubArrayLen(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);

    int sum = 0, maxLen = 0;

    for (int i = 0; i < nums.length; i++) {
        sum += nums[i];

        if (map.containsKey(sum - k)) {
            maxLen = Math.max(maxLen, i - map.get(sum - k));
        }

        map.putIfAbsent(sum, i);
    }

    return maxLen;
}
```

---

## 8. Mental Trigger Summary

👉 **“Subarray sum = k + negatives present → Prefix Sum + HashMap”**

---

# ✅ Problem 2 — Binary Search on Answer

## 1. Problem

**Koko Eating Bananas**

Find minimum eating speed so Koko finishes bananas within `h` hours.

---

## 2. Input

```
piles = [3,6,7,11]
h = 8
```

---

## 3. Output

```
4
```

---

## 4. Deep Breakdown

- We are asked for **minimum value satisfying a condition**
- Key signal:
  - “minimum X such that condition holds”

### Why brute force fails:

- Try all speeds → inefficient

### Tricky Part:

- Search space is not array index, but **range of values**

### Trigger Moment:

> “This is not searching index… I am searching answer space”

---

## 5. Pattern Identification

- ✅ **Binary Search on Answer**
- Condition:
  - If speed works → try smaller
  - Else → increase speed

---

## 6. Step-by-Step Thought Process

- Define search space: `1 → max(piles)`
- For each mid:
  - Calculate total hours needed

> “Condition is monotonic → binary search applicable”

---

## 7. Code (Java)

```java
public int minEatingSpeed(int[] piles, int h) {
    int left = 1, right = Arrays.stream(piles).max().getAsInt();

    while (left < right) {
        int mid = left + (right - left) / 2;

        if (canFinish(piles, h, mid)) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }

    return left;
}

private boolean canFinish(int[] piles, int h, int speed) {
    int hours = 0;

    for (int pile : piles) {
        hours += Math.ceil((double) pile / speed);
    }

    return hours <= h;
}
```

---

## 8. Mental Trigger Summary

👉 **“Minimum/maximum value satisfying condition → Binary Search on Answer”**

---

# ✅ Problem 3 — Dynamic Programming (1D)

## 1. Problem

**House Robber**

Max money without robbing adjacent houses.

---

## 2. Input

```
nums = [2,7,9,3,1]
```

---

## 3. Output

```
12
```

---

## 4. Deep Breakdown

- Decision at each house:
  - Rob or skip

### Why brute force fails:

- Exponential choices

### Tricky Part:

- Overlapping subproblems

### Trigger Moment:

> “I see choices + optimal substructure → DP”

---

## 5. Pattern Identification

- ✅ **DP (Decision-based / Include-Exclude)**

---

## 6. Step-by-Step Thought Process

- Define:
  - `dp[i] = max money till index i`

- Transition:
  - `dp[i] = max(dp[i-1], nums[i] + dp[i-2])`

> “At this point, I realize each state depends on previous 2 states”

---

## 7. Code (Java)

```java
public int rob(int[] nums) {
    if (nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];

    int prev2 = nums[0];
    int prev1 = Math.max(nums[0], nums[1]);

    for (int i = 2; i < nums.length; i++) {
        int curr = Math.max(prev1, nums[i] + prev2);
        prev2 = prev1;
        prev1 = curr;
    }

    return prev1;
}
```

---

## 8. Mental Trigger Summary

👉 **“Choice at each index + overlapping → DP include/exclude”**

---

# ✅ Problem 4 — Monotonic Stack

## 1. Problem

**Daily Temperatures**

Find how many days until a warmer temperature.

---

## 2. Input

```
[73,74,75,71,69,72,76,73]
```

---

## 3. Output

```
[1,1,4,2,1,1,0,0]
```

---

## 4. Deep Breakdown

- Need **next greater element**
- Brute force → O(n²)

### Tricky Part:

- Efficiently finding next greater for each element

### Trigger Moment:

> “Next greater element → monotonic stack”

---

## 5. Pattern Identification

- ✅ **Monotonic Stack (decreasing)**

---

## 6. Step-by-Step Thought Process

- Maintain decreasing stack of indices
- If current > stack top:
  - Resolve previous

> “Stack helps defer unresolved elements”

---

## 7. Code (Java)

```java
public int[] dailyTemperatures(int[] temperatures) {
    int n = temperatures.length;
    int[] res = new int[n];
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < n; i++) {
        while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
            int prevIndex = stack.pop();
            res[prevIndex] = i - prevIndex;
        }
        stack.push(i);
    }

    return res;
}
```

---

## 8. Mental Trigger Summary

👉 **“Next greater/smaller element → Monotonic Stack”**

---

# ✅ Problem 5 — Greedy

## 1. Problem

**Jump Game**

Can you reach last index?

---

## 2. Input

```
nums = [2,3,1,1,4]
```

---

## 3. Output

```
true
```

---

## 4. Deep Breakdown

- Each index gives max jump length
- Need feasibility, not path

### Why brute force fails:

- Exponential paths

### Tricky Part:

- Not DP → simpler greedy works

### Trigger Moment:

> “I only care about farthest reachable index”

---

## 5. Pattern Identification

- ✅ **Greedy (range expansion)**

---

## 6. Step-by-Step Thought Process

- Track `maxReach`
- If current index > maxReach → fail

> “I don’t need exact path, only reachability”

---

## 7. Code (Java)

```java
public boolean canJump(int[] nums) {
    int maxReach = 0;

    for (int i = 0; i < nums.length; i++) {
        if (i > maxReach) return false;

        maxReach = Math.max(maxReach, i + nums[i]);
    }

    return true;
}
```

---

## 8. Mental Trigger Summary

👉 **“Reachability + maximize range → Greedy”**

---

# 🔥 Final Coaching Insight (Important)

You are now building something critical:

👉 **Pattern → Trigger → Execution**

Here’s your current mental map:

| Signal                            | Pattern         |
| --------------------------------- | --------------- |
| Subarray sum = k (with negatives) | Prefix Sum      |
| Min/max value under constraint    | Binary Search   |
| Choice per index                  | DP              |
| Next greater/smaller              | Monotonic Stack |
| Range reachability                | Greedy          |

---

✅ Problem 1 — Sliding Window (Fixed/Variable Window)

1. Problem

Longest Substring Without Repeating Characters

You are given a string. Find the length of the longest substring (contiguous) that contains no repeating characters.

👉 In simple terms:
We want the maximum-length window where all characters are unique.

2. Input
   s = "abcabcbb"
3. Output
   3
4. Deep Breakdown
   a. Problem Signals
   Substring → contiguous
   Maximize length
   Constraint: no duplicates

👉 This screams: window expansion + constraint maintenance

b. Constraints Analysis
Brute force → O(n²) substrings
Checking uniqueness each time → O(n)
Total → O(n³) (too slow)
c. Brute Force
Generate all substrings
Check duplicates using set

❌ Not scalable

d. Theoretical Insight

Sliding window works when:

We process contiguous regions
We can incrementally update state

Key invariant:

Window always satisfies: no duplicates

When violated:

Move left pointer until invariant restored

This works because:

Each element enters & exits window at most once → O(n)
e. Trick / Twist
Not just finding substring — maintaining dynamic constraint
f. Pattern Trigger Moment

“Contiguous + longest + constraint → sliding window”

5. Pattern Identification
   ✅ Sliding Window (Variable Size)
   ❌ Prefix sum irrelevant (not sum-based)
   ❌ DP overkill
6. Step-by-Step Thought Process
   Expand right pointer
   If duplicate:
   Shrink from left
   Track max length

“I maintain a valid window at all times”

7.  Code (Java)
    public int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<>();
    int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;

    }

8.  Edge Cases & Common Mistakes
    Empty string → 0
    All same characters → 1
    Forgetting to shrink window properly
9.  Mental Trigger

👉 “Substring + longest + constraint → Sliding Window”

✅ Problem 2 — Prefix Sum

1. Problem

Subarray Sum Equals K

Given an array, count how many subarrays (contiguous) have sum equal to k.

👉 Output is count, not max length.

2. Input
   nums = [1,1,1]
   k = 2
3. Output
   2
4. Deep Breakdown
   a. Problem Signals
   Subarray → contiguous
   Sum equals k
   Count number of such subarrays
   b. Constraints
   Brute force → O(n²)
   Acceptable? No
   c. Brute Force
   Check all subarrays
   d. Theoretical Insight

Key equation:

prefix[j] - prefix[i] = k

Rearranged:

prefix[i] = prefix[j] - k

👉 So for each j, we need count of (prefix[j] - k)

This transforms:

O(n²) → O(n)

Invariant:

HashMap stores frequency of prefix sums

e. Trick / Twist
Counting, not maximizing
Multiple valid subarrays
f. Trigger Moment

“Subarray sum = k → prefix sum + hashmap”

5.  Pattern Identification
    ✅ Prefix Sum + Frequency Map
    ❌ Sliding window fails (negative numbers allowed)
6.  Thought Process
    Track cumulative sum
    Check if (sum - k) seen before
    Add frequency
7.  Code
    public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);

        int sum = 0, count = 0;

        for (int num : nums) {
            sum += num;

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;

    }

8.  Edge Cases
    Negative numbers
    k = 0
    Multiple overlaps
9.  Mental Trigger

👉 “Subarray sum = k → Prefix Sum + HashMap”

✅ Problem 3 — Binary Search on Answer

1. Problem

Capacity To Ship Packages Within D Days

Find the minimum ship capacity needed to ship all packages within D days.

2. Input
   weights = [1,2,3,4,5,6,7,8,9,10]
   D = 5
3. Output
   15
4. Deep Breakdown
   a. Signals
   “Minimum capacity such that condition holds”
   b. Constraints
   Try all capacities → large range
   c. Brute Force
   Try all values → inefficient
   d. Theory

Monotonic behavior:

If capacity works → larger will also work

👉 This forms a searchable space

Invariant:

Condition is monotonic → binary search applies

e. Trick
Not searching index — searching answer space
f. Trigger

“Minimize value under constraint → binary search on answer”

5.  Pattern
    ✅ Binary Search on Answer
6.  Thought Process
    Define range: max(weight) → sum(weight)
    Validate mid
7.  Code
    public int shipWithinDays(int[] weights, int days) {
    int left = Arrays.stream(weights).max().getAsInt();
    int right = Arrays.stream(weights).sum();

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canShip(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;

    }

private boolean canShip(int[] weights, int days, int capacity) {
int curr = 0, neededDays = 1;

    for (int w : weights) {
        if (curr + w > capacity) {
            neededDays++;
            curr = 0;
        }
        curr += w;
    }

    return neededDays <= days;

} 8. Edge Cases
Single package
Large weights
D = 1 9. Mental Trigger

👉 “Minimum feasible value + monotonic → Binary Search”

✅ Problem 4 — Dynamic Programming

1. Problem

Climbing Stairs

You can climb 1 or 2 steps. Count total ways to reach the top.

2. Input
   n = 5
3. Output
   8
4. Deep Breakdown
   a. Signals
   Count ways
   Choices at each step
   b. Theory

Recurrence:

f(n) = f(n-1) + f(n-2)

Why?

Last step either:
came from n-1
came from n-2

This is optimal substructure

c. Overlapping Subproblems
Same values recomputed
d. Trigger

“Count ways + choices → DP”

5.  Pattern
    ✅ DP (Fibonacci type)
6.  Thought Process
    Bottom-up or space optimized
7.  Code
    public int climbStairs(int n) {
    if (n <= 2) return n;

        int prev2 = 1, prev1 = 2;

        for (int i = 3; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;

    }

8.  Edge Cases
    n = 1
    n = 2
9.  Mental Trigger

👉 “Count ways + recurrence → DP (Fibonacci pattern)”

✅ Problem 5 — Greedy

1. Problem

Gas Station

Find starting index to complete a circular route.

2. Input
   gas = [1,2,3,4,5]
   cost = [3,4,5,1,2]
3. Output
   3
4. Deep Breakdown
   a. Signals
   Circular traversal
   Feasibility problem
   b. Theory

Key insight:

If total gas < total cost → impossible

Greedy invariant:

If current tank < 0:
Any previous start is invalid
c. Why Greedy Works

Because:

Failure at i means any start before i also fails

d. Trigger

“Local failure invalidates previous → greedy reset”

5.  Pattern
    ✅ Greedy
6.  Thought Process
    Track tank
    Reset start when negative
7.  Code
    public int canCompleteCircuit(int[] gas, int[] cost) {
    int total = 0, tank = 0, start = 0;

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;

            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return total >= 0 ? start : -1;

    }

8.  Edge Cases
    No solution
    Single station
9.  Mental Trigger

👉 “If failure invalidates past → Greedy reset”

🔥 Final Coaching Note

You are now building:

Recognition Layer
Subarray + sum → Prefix
Substring + constraint → Sliding Window
Min/max under condition → Binary Search
Choices → DP
Feasibility + local decisions → Greedy

---

✅ Problem 1 — Two Pointers

1. Problem

Container With Most Water

You are given heights of vertical lines. Choose two lines such that they form a container holding the maximum water.

👉 In simple terms:
Pick two indices i and j to maximize:
min(height[i], height[j]) \* (j - i)

2. Input
   height = [1,8,6,2,5,4,8,3,7]
3. Output
   49
4. Deep Breakdown
   a. Problem Signals
   Two indices
   Maximize area
   Brute force → check all pairs
   b. Constraints
   O(n²) too slow
   c. Brute Force
   Try all pairs → compute area
   d. Theoretical Insight

Key idea:

Area depends on shorter line

If we move the taller line:

Width decreases
Height remains limited by shorter → no improvement

Invariant:

Always try to improve the limiting factor (shorter line)

e. Trick / Twist
Counterintuitive: move the smaller pointer, not larger
f. Trigger Moment

“Two ends + maximize/minimize → Two pointers”

5.  Pattern Identification
    ✅ Two Pointers (opposite ends)
    ❌ Sliding window not applicable
6.  Thought Process
    Start with widest container
    Move smaller pointer inward
7.  Code
    public int maxArea(int[] height) {
    int left = 0, right = height.length - 1;
    int max = 0;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;

    }

8.  Edge Cases
    All equal heights
    Very small array
9.  Mental Trigger

👉 “Two ends + maximize → Move limiting side (Two Pointers)”

✅ Problem 2 — Fast & Slow Pointer

1. Problem

Linked List Cycle

Detect if a linked list has a cycle.

2. Input

Linked list: 3 → 2 → 0 → -4 → (points back to 2)

3. Output
   true
4. Deep Breakdown
   a. Signals
   Linked list
   Cycle detection
   b. Brute Force
   Store visited nodes → O(n) space
   c. Theoretical Insight

Floyd’s Cycle Detection:

Slow moves 1 step
Fast moves 2 steps

If cycle exists:

Fast will eventually meet slow

Why?

Relative speed = 1
Like circular race
d. Trick
Works without extra space
e. Trigger

“Cycle in linked list → fast & slow pointer”

5.  Pattern
    ✅ Fast & Slow Pointer
6.  Thought Process
    Move pointers
    If they meet → cycle
7.  Code
    public boolean hasCycle(ListNode head) {
    if (head == null) return false;

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }

        return false;

    }

8.  Edge Cases
    Single node
    No cycle
9.  Mental Trigger

👉 “Cycle detection → Fast & Slow pointers”

✅ Problem 3 — Backtracking

1. Problem

Subsets

Generate all possible subsets of an array.

2. Input
   nums = [1,2,3]
3. Output
   [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
4. Deep Breakdown
   a. Signals
   Generate all combinations
   Power set
   b. Theory

Decision tree:

At each element:
include
exclude

Total → 2ⁿ

Invariant:

Explore all possibilities, undo after recursion

c. Trick
Requires careful state management
d. Trigger

“Generate all combinations → Backtracking”

5. Pattern
   ✅ Backtracking
6. Thought Process
   Recursive tree
   Add → recurse → remove
7. Code
   public List<List<Integer>> subsets(int[] nums) {
   List<List<Integer>> result = new ArrayList<>();
   backtrack(nums, 0, new ArrayList<>(), result);
   return result;
   }

private void backtrack(int[] nums, int start, List<Integer> curr, List<List<Integer>> result) {
result.add(new ArrayList<>(curr));

    for (int i = start; i < nums.length; i++) {
        curr.add(nums[i]);
        backtrack(nums, i + 1, curr, result);
        curr.remove(curr.size() - 1);
    }

} 8. Edge Cases
Empty input → [[]] 9. Mental Trigger

👉 “Generate all possibilities → Backtracking (include/exclude)”

✅ Problem 4 — Heap / Priority Queue

1. Problem

Kth Largest Element in an Array

Find the k-th largest element.

2. Input
   nums = [3,2,1,5,6,4], k = 2
3. Output
   5
4. Deep Breakdown
   a. Signals
   k-th largest
   Not full sort required
   b. Theory

Use min-heap of size k:

Keep top k largest elements

Invariant:

Heap always contains k largest elements so far

c. Trick
Don’t sort entire array
d. Trigger

“k-th largest/smallest → heap”

5.  Pattern
    ✅ Heap
6.  Thought Process
    Maintain heap size k
7.  Code
    public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();

    }

8.  Edge Cases
    k = 1
    duplicates
9.  Mental Trigger

👉 “Top K element → Heap (size k)”

✅ Problem 5 — Interval Merging

1. Problem

Merge Intervals

Merge all overlapping intervals.

2. Input
   intervals = [[1,3],[2,6],[8,10],[15,18]]
3. Output
   [[1,6],[8,10],[15,18]]
4. Deep Breakdown
   a. Signals
   Intervals
   Overlapping ranges
   b. Theory

Sort by start time

Invariant:

If current start ≤ previous end → merge

c. Trick
Sorting simplifies problem
d. Trigger

“Overlapping intervals → sort + merge”

5.  Pattern
    ✅ Interval Merging
6.  Thought Process
    Sort
    Merge greedily
7.  Code
    public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= current[1]) {
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                result.add(current);
                current = intervals[i];
            }
        }

        result.add(current);
        return result.toArray(new int[result.size()][]);

    }

8.  Edge Cases
    Single interval
    Fully overlapping
9.  Mental Trigger

👉 “Intervals + overlap → Sort + Merge”

🔥 Final Pattern Map (Expanded)

You now have 10 core patterns:

Category Pattern
Window Sliding Window
Sum Prefix Sum
Search Binary Search
Optimization DP
Local decisions Greedy
Pair problems Two Pointers
Cycles Fast/Slow Pointer
Combinations Backtracking
Top K Heap
Ranges Interval Merge
