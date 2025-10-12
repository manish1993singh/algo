// Question 1: Path Exists in a Graph using DFS
// Given an undirected graph and two nodes, determine if a path exists between them using DFS.
// Sample Input:
// Nodes: 0, 1, 2, 3, 4
// Edges: [[0,1],[0,2],[1,2],[1,3],[2,4]]
// Start: 0, End: 4
// Sample Output:
// Path exists: true
// Limitations:
// - Graph is unweighted and undirected
// - All nodes are labeled with integers
// - No negative cycles
//
// Pseudocode:
// 1. Start DFS from the start node.
// 2. Mark nodes as visited.
// 3. For each neighbor, recursively call DFS if not visited.
// 4. If end node is reached, return true.
// 5. If all paths explored and end not reached, return false.
//
// Guidance:
// - Use recursion or a stack for DFS traversal.
// - Use a Set to track visited nodes.
// - Handle disconnected graphs (return false if no path).
public class DFS_PathExists {
    // Implement here
}
