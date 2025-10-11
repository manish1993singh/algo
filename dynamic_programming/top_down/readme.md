🧠 Top-Down (Memoization)
Best suited for:

- Problems with overlapping subproblems but not all subproblems are needed.
- Recursive solutions where the same inputs are recalculated multiple times.
- Smaller input sizes or when recursion depth is manageable.

  Use cases:

- Fibonacci sequence
- Recursive tree-based problems (e.g., binary tree traversals with caching)
- Knapsack problem (when only a subset of states are explored)

  Advantages:

- Easy to implement if you already have a recursive solution.
- Only computes the subproblems that are actually needed.
- Good for prototyping and understanding problem structure.

  Drawbacks:

- Risk of stack overflow with deep recursion.
- Slightly slower due to recursive overhead.
