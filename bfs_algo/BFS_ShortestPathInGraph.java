// Question 1: Shortest Path in an Unweighted Graph using BFS
// Given an undirected graph and two nodes, find the shortest path between them using BFS.
// Sample Input:
// Nodes: 0, 1, 2, 3, 4
// Edges: [[0,1],[0,2],[1,2],[1,3],[2,4]]
// Start: 0, End: 4
// Sample Output:
// Shortest path: [0,2,4]
// Limitations:
// - Graph is unweighted and undirected
// - All nodes are labeled with integers
// - No negative cycles
//
// Pseudocode:
// 1. Initialize a queue and add the start node.
// 2. Track visited nodes and parent mapping.
// 3. While queue is not empty:
//    a. Dequeue node, check if it's the end node.
//    b. For each neighbor, if not visited, mark visited, set parent, enqueue.
// 4. Reconstruct path from end to start using parent mapping.
//
// Guidance:
// - Use a Queue for BFS traversal.
// - Use a Map to track parents for path reconstruction.
// - Handle disconnected graphs (return empty if no path).
public class BFS_ShortestPathInGraph {
    // Implement here
}
