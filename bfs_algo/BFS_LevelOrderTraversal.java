package bfs_algo;
// Question 2: Level Order Traversal of a Graph using BFS
// Given a graph and a starting node, print nodes level by level (distance from start).
// Sample Input:
// Nodes: 0, 1, 2, 3, 4
// Edges: [[0,1],[0,2],[1,3],[2,4]]
// Start: 0
// Sample Output:
// Level 0: [0]
// Level 1: [1,2]
// Level 2: [3,4]
// Limitations:
// - Graph is unweighted and undirected
// - All nodes are labeled with integers
// - No negative cycles
//
// Pseudocode:
// 1. Initialize a queue and add the start node.
// 2. Track visited nodes and current level.
// 3. While queue is not empty:
//    a. For each node in current level, dequeue and add to result.
//    b. Enqueue all unvisited neighbors for next level.
// 4. Repeat for all levels.
//
// Guidance:
// - Use a Queue for BFS traversal.
// - Use a Set to track visited nodes.
// - Use a List of Lists to store nodes at each level.

import java.util.Queue;

// Node class for graph representation
class Node {
    int data;
    Node[] neighbors;

    Node(int item, int size) {
        data = item;
        neighbors = new Node[size];
    }
}

public class BFS_LevelOrderTraversal {

    public void levelOrderTraversal(Node start) {
        if (start == null) return;

        Queue<Node> queue = new java.util.LinkedList<>();
        java.util.Set<Node> visited = new java.util.HashSet<>();
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            java.util.List<Integer> currentLevel = new java.util.ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                currentLevel.add(currentNode.data);

                for (Node neighbor : currentNode.neighbors) {
                    if (neighbor != null && !visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
            result.add(currentLevel);
        }

        // Print the result
        for (int i = 0; i < result.size(); i++) {
            System.out.println("Level " + i + ": " + result.get(i));
        }
    }

    public static void main(String[] args) {
        // Example graph as a social network (users 0-4)
        BFS_LevelOrderTraversal graphExample = new BFS_LevelOrderTraversal();
        Node node0 = new Node(0, 5);
        Node node1 = new Node(1, 5);
        Node node2 = new Node(2, 5);
        Node node3 = new Node(3, 5);
        Node node4 = new Node(4, 5);

        // Manually creating edges
        node0.neighbors[1] = node1;
        node0.neighbors[2] = node2;
        node1.neighbors[0] = node0;
        node1.neighbors[3] = node3;
        node2.neighbors[0] = node0;
        node2.neighbors[4] = node4;
        node3.neighbors[1] = node1;
        node4.neighbors[2] = node2;

        System.out.println("Level Order Traversal starting from Node 0:");
        graphExample.levelOrderTraversal(node0);
    }
}
