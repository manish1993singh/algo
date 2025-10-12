package dfs_algo;
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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Node {
    int data;
    List<Node> neighbors;

    Node(int item){
        data = item;
        neighbors = new ArrayList<>();
    }
}

public class DFS_AllPaths {
    public List<List<Integer>> allPaths(Node start, Node end){
        List<List<Integer>> result = new ArrayList<>();
        Set<Node> visited = new HashSet<>();
        List<Integer> currentPath = new ArrayList<>();
        traverse(start, end, visited, currentPath, result);
        return result;
    }

    private void traverse(Node currentNode, Node endNode, Set<Node> visited, List<Integer> currentPath, List<List<Integer>> result ){
        visited.add(currentNode);
        currentPath.add(currentNode.data);
        
        if(currentNode == endNode){
            result.add(new ArrayList<>(currentPath));
        }else{
            for(Node neighbor: currentNode.neighbors){
                if(!visited.contains(neighbor)){
                    traverse(neighbor, endNode, visited, currentPath, result);
                }
            }
        }

        currentPath.remove(currentPath.size() - 1);
        visited.remove(currentNode);
    }

    public static void main(String[] args){
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node( 2);
        Node node3 = new Node(3);

        node0.neighbors.add(node1);
        node0.neighbors.add(node2);
        node1.neighbors.add(node3);
        node2.neighbors.add(node3);

        DFS_AllPaths dfs_AllPaths = new DFS_AllPaths();

        List<List<Integer>> result = dfs_AllPaths.allPaths(node0, node3);

        System.out.println(result);

    }
}
