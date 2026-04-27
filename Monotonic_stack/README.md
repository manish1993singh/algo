# Monotonic Stack

A monotonic stack is a stack data structure that maintains its elements in either strictly increasing or strictly decreasing order. It is useful for solving problems where you need to find the next greater/smaller element, span queries, or ranges involving comparisons between neighboring elements.

## Key idea

- Use a stack to store indices or values.
- Keep the stack monotonic by popping elements that break the ordering.
- When an element is popped, it means the current element is the "next greater" or "next smaller" for that popped element.

## Common patterns

1. Next greater element to the right
2. Next smaller element to the right
3. Next greater/smaller element to the left
4. Temperature span problems
5. Stock span / nearest greater element

## When to use it

Ask yourself:

- Does the problem need the next larger or smaller item for each element?
- Is the input scanned left-to-right with comparisons to earlier elements?
- Can you solve it by keeping only a subset of previous candidates?

If yes, a monotonic stack is often the right pattern.

## Example problem

```
Input: [73, 74, 75, 71, 69, 72, 76, 73]
Output: [1, 1, 4, 2, 1, 1, 0, 0]
```

For each day, the output shows how many days until a warmer temperature appears.

## Visual explanation

```mermaid
flowchart TB
    subgraph Input
      A[73] --> B[74]
      B --> C[75]
      C --> D[71]
      D --> E[69]
      E --> F[72]
      F --> G[76]
      G --> H[73]
    end

    subgraph Stack[Monotonic Stack (indices)]
      S1[0: 73]
      S2[1: 74]
      S3[2: 75]
      S4[3: 71]
      S5[4: 69]
    end

    A -->|push 0| S1
    B -->|pop 0| S2
    C -->|pop 1,2| S3
    D -->|push 3| S4
    E -->|push 4| S5
    F -->|pop 4,3| S3
    G -->|pop 2| S3
    H -->|push 7| S4

    style Stack fill:#f9f,stroke:#333,stroke-width:1px
```

### Step-by-step

1. Start with an empty stack.
2. Read the current element.
3. While the stack is not empty and the current value is greater/smaller than the value at the top of the stack, pop from the stack.
4. Use the popped index to compute the answer for that position.
5. Push the current index onto the stack.

## Pseudocode

```text
for i in 0..n-1:
  while stack not empty and nums[i] > nums[stack.top]:
    idx = stack.pop()
    answer[idx] = i - idx
  stack.push(i)
```

## Java example

The `Next_hot_day.java` file in this folder is a classic monotonic stack implementation for the daily temperatures problem. It stores indices in the stack and computes how many days it takes until a warmer temperature.

## Why it is efficient

- Each element is pushed once and popped at most once.
- Time complexity: O(n)
- Space complexity: O(n)

## Variations

- Use a decreasing stack for next greater element problems.
- Use an increasing stack for next smaller element problems.
- Store indices when you need distance or span information.
- Store values directly when only the values matter.

## Summary

Monotonic stacks are powerful for problems where earlier items are only relevant while they can still be the next greater or smaller candidate. They convert what could be an O(n²) brute-force scan into linear time by discarding obsolete candidates immediately.
