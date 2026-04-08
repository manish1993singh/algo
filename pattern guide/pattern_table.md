🔥 DSA MASTER PATTERN TABLE (Interview-Focused)

# Pattern Key Signals (When to Think This) Core Idea Common Applications Why It Works (Theory) Pitfalls

| #   | Pattern                   | Key Signals                                                  | Core Idea                   | Common Applications                           | Why It Works                                    | Pitfalls                        |
| --- | ------------------------- | ------------------------------------------------------------ | --------------------------- | --------------------------------------------- | ----------------------------------------------- | ------------------------------- |
| 1   | Sliding Window            | Substring / subarray, contiguous, max/min length, constraint | Expand & shrink window      | Longest substring, min window, fixed size sum | Maintains invariant over window; O(n) traversal | Fails with negative sums        |
| 2   | Prefix Sum                | Subarray sum = k, cumulative sums, range queries             | Store running sum           | Subarray count, range sum queries             | prefix[j] - prefix[i] = k                       | Forgetting hashmap init (0 → 1) |
| 3   | Two Pointers              | Sorted array OR two ends, pairs, maximize/minimize           | Move pointers strategically | Pair sum, container problem                   | Reduces search space from both ends             | Wrong pointer movement logic    |
| 4   | Fast & Slow Pointer       | Cycle detection, middle element                              | Two speeds                  | Linked list cycle, middle node                | Relative speed guarantees meeting               | Missing null checks             |
| 5   | Binary Search (Index)     | Sorted array, search element                                 | Divide search space         | Classic search                                | Log(n) divide-and-conquer                       | Off-by-one errors               |
| 6   | Binary Search on Answer   | Min/max value under constraint, monotonic behavior           | Search solution space       | Capacity, speed, allocation problems          | Monotonic condition enables binary search       | Wrong search bounds             |
| 7   | Greedy                    | Local optimal → global optimal, feasibility                  | Make best local choice      | Jump game, intervals, gas station             | Exchange argument / greedy stays optimal        | When DP is actually needed      |
| 8   | Dynamic Programming       | Choices, optimization, overlapping subproblems               | Store results               | Knapsack, paths, sequences                    | Optimal substructure + reuse                    | Wrong state definition          |
| 9   | Backtracking              | Generate all combinations/permutations                       | Explore + undo              | Subsets, permutations, N-Queens               | DFS over decision tree                          | Not pruning → TLE               |
| 10  | Heap (Priority Queue)     | Top K, smallest/largest repeatedly                           | Maintain ordered structure  | Kth largest, merge k lists                    | Heap keeps best candidates                      | Using full sort unnecessarily   |
| 11  | Interval Problems         | Overlapping ranges, scheduling                               | Sort + merge                | Merge intervals, meeting rooms                | Sorting simplifies relationships                | Forgetting to sort              |
| 12  | Graph Traversal (BFS/DFS) | Grid, connectivity, components                               | Visit neighbors             | Islands, shortest path                        | Graph traversal explores components             | Revisiting nodes                |
| 13  | Topological Sort          | Dependencies, ordering, DAG                                  | Process indegree 0 nodes    | Course schedule, build systems                | DAG linear ordering exists                      | Not detecting cycle             |
| 14  | Union Find (DSU)          | Connectivity, grouping, dynamic unions                       | Merge sets                  | Components, network problems                  | Tracks connected components efficiently         | Missing path compression        |
| 15  | Trie                      | Prefix search, dictionary words                              | Tree of characters          | Autocomplete, prefix matching                 | Prefix sharing reduces complexity               | High memory usage               |
| 16  | Bit Manipulation          | Duplicates cancel, binary tricks                             | XOR / bit ops               | Single number, subsets                        | Bitwise properties (XOR cancel)                 | Hard to visualize               |
| 17  | Monotonic Stack           | Next greater/smaller element                                 | Maintain order in stack     | Histogram, temperature                        | Stack ensures monotonic property                | Choosing wrong direction        |
| 18  | Kadane’s Algorithm        | Max/min subarray sum                                         | Running max                 | Max subarray                                  | Optimal substructure                            | Handling all negatives          |
| 19  | Matrix Traversal          | 2D grid movement                                             | Directional traversal       | BFS/DFS grid problems                         | Implicit graph                                  | Boundary errors                 |
| 20  | Divide & Conquer          | Split problem into halves                                    | Recursive split             | Merge sort, quick sort                        | Reduces complexity                              | Stack depth                     |

🔥 Pattern Trigger Cheatsheet (MOST IMPORTANT)

Memorize these like formulas:

- “Substring + constraint → Sliding Window”
- “Subarray sum = k → Prefix Sum”
- “Sorted + pair → Two Pointers”
- “Cycle → Fast & Slow Pointer”
- “Min/max satisfying condition → Binary Search”
- “Choices + optimize → DP”
- “Generate all → Backtracking”
- “Top K → Heap”
- “Overlap → Intervals”
- “Grid/connected → BFS/DFS”
- “Dependencies → Topological Sort”
- “Dynamic connectivity → Union Find”
- “Prefix matching → Trie”
- “Duplicates cancel → XOR”
- “Next greater → Monotonic Stack”
- “Max subarray → Kadane”

🔥 How Senior Engineers Actually Use This
