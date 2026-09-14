|   # | Category     | Pattern                        | Use When / Signals                                | Typical Problems                              |
| --: | ------------ | ------------------------------ | ------------------------------------------------- | --------------------------------------------- |
|   1 | Array        | Fixed Sliding Window           | Exact window size `k`                             | Max sum of size k                             |
|   2 | Array        | Variable Sliding Window        | Contiguous + monotonic constraint                 | Longest/shortest subarray                     |
|   3 | Array        | Prefix Sum                     | Range sums / cumulative sums                      | Range Sum Query                               |
|   4 | Array        | Prefix Sum + HashMap           | Count/exact-sum subarrays                         | Subarray Sum = K                              |
|   5 | Array        | Prefix Sum + Modulo            | Divisibility                                      | Subarrays divisible by K                      |
|   6 | Array        | Kadane                         | Maximum/minimum contiguous sum                    | Max Subarray                                  |
|   7 | Array        | Difference Array               | Many range updates                                | Range increment                               |
|   8 | Array        | Two Pointers — Opposite        | Sorted data / pair relationship                   | Two Sum II                                    |
|   9 | Array        | Two Pointers — Same Direction  | In-place filtering/deduplication                  | Remove Duplicates                             |
|  10 | Array        | Binary Search                  | Sorted/search space                               | Search in sorted array                        |
|  11 | Array        | Lower/Upper Bound              | First/last valid position                         | Search range                                  |
|  12 | Array        | Binary Search on Answer        | Optimize value + feasibility check                | Split Array Largest Sum                       |
|  13 | Array        | Dutch National Flag            | 3-way partition                                   | Sort Colors                                   |
|  14 | Array        | Cyclic Sort                    | Values in `[1,n]` / index mapping                 | Missing/Duplicate Number                      |
|  15 | Array        | HashMap / HashSet              | Fast lookup/frequency                             | Two Sum, duplicates                           |
|  16 | Array        | Bit Manipulation               | XOR, masks, binary properties                     | Single Number                                 |
|  17 | String       | Sliding Window                 | Substring constraints                             | Longest substring                             |
|  18 | String       | Frequency Map                  | Character counts                                  | Anagrams                                      |
|  19 | String       | Expand Around Center           | Palindromes                                       | Longest Palindromic Substring                 |
|  20 | String       | String DP                      | Sequence/edit decisions                           | Edit Distance                                 |
|  21 | Stack        | Monotonic Stack                | Next greater/smaller                              | Daily Temperatures                            |
|  22 | Stack        | Monotonic Stack — Contribution | Sum of min/max across subarrays                   | Sum of Subarray Minimums                      |
|  23 | Stack        | Validation Stack               | Nested structure                                  | Valid Parentheses                             |
|  24 | Stack        | Expression Stack               | Expression evaluation                             | Calculator                                    |
|  25 | Queue        | Monotonic Deque                | Window max/min                                    | Sliding Window Maximum                        |
|  26 | Queue        | BFS                            | Level traversal / unweighted shortest path        | Binary Tree Level Order                       |
|  27 | Queue        | Multi-Source BFS               | Multiple starting points spreading simultaneously | Rotting Oranges, distance from nearest source |
|  28 | Heap         | Min/Max Heap                   | Top K / dynamic ordering                          | Kth Largest                                   |
|  29 | Heap         | Two Heaps                      | Maintain two balanced halves                      | Median from Data Stream                       |
|  30 | Linked List  | Fast & Slow Pointer            | Cycle/middle                                      | Linked List Cycle                             |
|  31 | Linked List  | In-Place Reversal              | Reverse nodes without extra space                 | Reverse Linked List                           |
|  32 | Linked List  | In-Place Reversal — Groups     | Reverse fixed-size portions                       | Reverse Nodes in K-Group                      |
|  33 | Linked List  | Merge Lists                    | Ordered linked lists                              | Merge K Sorted Lists                          |
|  34 | Greedy       | Interval Scheduling            | Maximize compatible intervals                     | Activity Selection                            |
|  35 | Greedy       | Interval Merge                 | Overlapping intervals                             | Merge Intervals                               |
|  36 | Greedy       | Jump/Reachability              | Local farthest reach                              | Jump Game                                     |
|  37 | Greedy       | Resource Allocation            | Sort + allocate optimally                         | Meeting Rooms                                 |
|  38 | Backtracking | Subsets                        | Generate all subsets                              | Power Set                                     |
|  39 | Backtracking | Permutations                   | Generate all orderings                            | Permutations                                  |
|  40 | Backtracking | Combinations                   | Choose elements under constraints                 | Combination Sum                               |
|  41 | Backtracking | Partitioning                   | Generate valid partitions                         | Palindrome Partitioning                       |
|  42 | DP           | 1D / Fibonacci                 | Current state depends on previous states          | Climbing Stairs                               |
|  43 | DP           | 0/1 Knapsack                   | Take/skip, each item once                         | Partition Equal Subset Sum                    |
|  44 | DP           | Unbounded Knapsack             | Item can be reused                                | Coin Change                                   |
|  45 | DP           | LCS                            | Compare two sequences                             | Longest Common Subsequence                    |
|  46 | DP           | LIS                            | Increasing subsequence                            | Longest Increasing Subsequence                |
|  47 | DP           | Grid DP                        | Grid paths/optimization                           | Unique Paths                                  |
|  48 | DP           | String DP                      | Transform/match strings                           | Edit Distance                                 |
|  49 | DP           | Interval DP                    | Solve smaller intervals first                     | Matrix Chain Multiplication                   |
|  50 | DP           | Bitmask DP                     | State represented by subset                       | Traveling Salesman                            |
|  51 | DP           | **Tree DP**                    | Optimal decision depends on child subtrees        | House Robber III, Tree Diameter variants      |
|  52 | Tree         | DFS                            | Recursive tree exploration                        | Path Sum, LCA                                 |
|  53 | Tree         | BFS / Level Order              | Level-based processing                            | Right Side View                               |
|  54 | Tree         | BST Pattern                    | Ordered-tree property                             | Validate/Search BST                           |
|  55 | Graph        | DFS                            | Components/reachability                           | Number of Islands                             |
|  56 | Graph        | BFS                            | Unweighted shortest path                          | Word Ladder                                   |
|  57 | Graph        | **Multi-Source BFS**           | Distance/spread from many sources                 | Rotting Oranges                               |
|  58 | Graph        | Topological Sort               | Dependency ordering / DAG                         | Course Schedule                               |
|  59 | Graph        | Union Find                     | Dynamic connectivity                              | Number of Connected Components                |
|  60 | Graph        | Dijkstra                       | Weighted shortest path, non-negative weights      | Network Delay                                 |
|  61 | Graph        | Bellman-Ford                   | Negative edge weights                             | Cheapest Flights                              |
|  62 | Graph        | Minimum Spanning Tree          | Connect everything at minimum cost                | Kruskal / Prim                                |
|  63 | Trie         | Prefix Tree                    | Prefix-based lookup                               | Word Search, Autocomplete                     |
|  64 | Geometry     | Sweep Line                     | Events along a coordinate axis                    | Meeting Rooms II                              |
|  65 | Range Query  | Segment Tree                   | Range query + updates                             | Range Minimum Query                           |
|  66 | Range Query  | Fenwick Tree                   | Prefix/range sums with updates                    | Dynamic frequency sums                        |
