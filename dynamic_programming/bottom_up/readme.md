🧱 Bottom-Up (Tabulation)
Best suited for:

- Problems where all subproblems are needed to build the final solution.
- Iterative solutions with clear dependency order.
- Large input sizes where recursion would be inefficient or risky.

  Use cases:

- Longest Common Subsequence
- Edit Distance
- Coin Change
- Matrix chain multiplication

  Advantages:

- No recursion overhead.
- Often faster and more memory-efficient.
- Easier to optimize further (e.g., space optimization).

  Drawbacks:

- Requires careful planning of iteration order.
- May compute unnecessary subproblems.
