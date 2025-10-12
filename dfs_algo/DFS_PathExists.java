package dfs_algo;
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
// 3. For each neighbors, recursively call DFS if not visited.
// 4. If end node is reached, return true.
// 5. If all paths explored and end not reached, return false.
//
// Guidance:
// - Use recursion or a stack for DFS traversal.
// - Use a Set to track visited nodes.
// - Handle disconnected graphs (return false if no path).

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Node {
    int data;
    List<Node> neighbors;

    public Node(int data){
        this.data = data;
        neighbors = new ArrayList<Node>();
    }
    
}

public class DFS_PathExists {
    public boolean pathExist(Node startNode, Node endNode){
        Set<Node> visited = new HashSet<>();
        return traverse(startNode, endNode, visited);
    }

    public boolean traverse(Node currentNode, Node endNode, Set<Node> visited){
        visited.add(currentNode);
        if(currentNode == endNode){
            return true;
        }else{
            for(Node neighbor: currentNode.neighbors){
                if(!visited.contains(neighbor)){
                    if(traverse(neighbor, endNode, visited)){
                        return true;
                    };
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node0.neighbors.add(node1);
        node0.neighbors.add(node2);
        node1.neighbors.add(node3);
        node1.neighbors.add(node2);
        node2.neighbors.add(node4);

        boolean result = new DFS_PathExists().pathExist(node0, node5);
        System.out.println("Does path exists? Answer: "+result);
    }

}
