
// Real-world use cases of Graphs:
// 1. Social Networks: Users are nodes, friendships/follows are edges.
// 2. Maps & Navigation: Locations are nodes, roads/paths are edges.
// 3. Internet/Web: Webpages are nodes, hyperlinks are edges.
// 4. Recommendation Systems: Products/users as nodes, similarities as edges.
// 5. Network Routing: Routers/computers as nodes, connections as edges.
// 6. Scheduling/Dependency: Tasks as nodes, dependencies as edges (DAGs).

package java_basics;

public class Graph_ {
    // Graph node class
    // In real-world, a node could represent a user, city, computer, etc.
    static class Node {
        int data;
        Node[] neighbors;

        Node(int item, int size) {
            data = item;
            neighbors = new Node[size];
        }
    }

    // Example graph representation using adjacency list
    // Adjacency lists are efficient for sparse graphs, common in real-world networks.
    Node[] graph;

    public Graph_(int size) {
        graph = new Node[size];
        for (int i = 0; i < size; i++) {
            graph[i] = new Node(i, size);
        }
    }

    // Method to add an edge between two nodes
    // In real-world, adding an edge could mean creating a friendship, road, or network link.
    public void addEdge(int src, int dest) {
        graph[src].neighbors[dest] = graph[dest];
        graph[dest].neighbors[src] = graph[src]; // For undirected graph
    }

    // Display the graph
    // Useful for visualizing connections, e.g., showing friends of a user or routes from a city.
    public void displayGraph() {
        for (Node node : graph) {
            System.out.print("Node " + node.data + " connected to: ");
            for (Node neighbor : node.neighbors) {
                if (neighbor != null) {
                    System.out.print(neighbor.data + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Example: Graph as a social network (users 0-4)
        // addEdge(0, 1) means user 0 and user 1 are friends
        Graph_ g = new Graph_(5);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        System.out.println("Graph representation (Adjacency List):");
        g.displayGraph();
    }
}
