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
