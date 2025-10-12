package bfs_algo;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Node {
    int data;
    Node[] neighbors;

    Node(int item, int size) {
        data = item;
        neighbors = new Node[size];
    }    
}

public class BFS_ShortestPathInGraph {
    public java.util.List<Integer> shortestPath(Node start, Node end) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        Map<Node, Node> parentMap = new HashMap<>();
        queue.add(start);
        visited.add(start);
        parentMap.put(start, null);
        while(!queue.isEmpty()){
            Node currentNode = queue.poll();
            if(currentNode == end){
                return reconstructPath(parentMap, end);
            }
            for(Node neighbor: currentNode.neighbors){
                if(neighbor != null && !visited.contains(neighbor)){
                    visited.add(neighbor);
                    parentMap.put(neighbor, currentNode);
                    queue.add(neighbor);
                }
            }
        }
        return null;
    }

    private java.util.List<Integer> reconstructPath(java.util.Map<Node, Node> parentMap, Node end) {
        List<Integer> path = new ArrayList<>();
        for(Node at = end; at != null; at = parentMap.get(at)){
            path.add(at.data);
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        Node node0 = new Node(0, 2);
        Node node1 = new Node(1, 2);
        Node node2 = new Node(2, 2);
        Node node3 = new Node(3, 2);
        Node node4 = new Node(4, 2);

        // Manually creating edges
        node0.neighbors[0] = node1;
        node0.neighbors[1] = node2;
        node1.neighbors[0] = node0;
        node1.neighbors[1] = node3;
        node2.neighbors[0] = node0;
        node2.neighbors[1] = node4;
        node3.neighbors[0] = node1;
        node4.neighbors[0] = node2;

        BFS_ShortestPathInGraph bfs = new BFS_ShortestPathInGraph();
        List<Integer> path = bfs.shortestPath(node0, node4);
        if(path != null){ 
            System.out.println("Shortest path: " + path);
        } else {
            System.out.println("No path found.");
        }
    }
}
