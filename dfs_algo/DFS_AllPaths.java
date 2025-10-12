// Question 2: Find All Paths Between Two Nodes using DFS
// Given a graph and two nodes, print all possible paths between them using DFS.
// Sample Input:
// Nodes: 0, 1, 2, 3
// Edges: [[0,1],[0,2],[1,3],[2,3]]
// Start: 0, End: 3
// Sample Output:
// All paths:
// [0,1,3]
// [0,2,3]
// Limitations:
// - Graph is unweighted and undirected
// - All nodes are labeled with integers
// - No negative cycles
//
// Pseudocode:
// 1. Start DFS from the start node.
// 2. Track current path and visited nodes.
// 3. For each neighbor, recursively call DFS if not visited.
// 4. If end node is reached, add current path to result.
// 5. Backtrack after exploring each path.
//
// Guidance:
// - Use recursion for DFS traversal.
// - Use a List to track the current path.
// - Use a Set to track visited nodes.
// - Backtrack properly to explore all paths.
public class DFS_AllPaths {
    // Implement here
}
