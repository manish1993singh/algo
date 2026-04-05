//It is also known as Kahn's algorithm
package bfs_algo;

import java.util.*;

public class Course_completion {
    
    // Kahn's algorithm for topological sorting
    // Used to determine if courses can be completed given prerequisites
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Build the graph and indegree array
        // indegree[i] represents the number of prerequisites for course i
        int[] indegree = new int[numCourses];
        
        // Adjacency list: graph[i] contains courses that depend on course i
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // Populate graph and indegree
        for (int[] prereq : prerequisites) {
            int course = prereq[0]; // course to take
            int prereqCourse = prereq[1]; // prerequisite course
            graph[prereqCourse].add(course); // prereqCourse -> course
            indegree[course]++; // increase indegree of course
        }
        
        // Step 2: Initialize queue with courses having no prerequisites (indegree 0)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        // Step 3: Process the queue
        int completedCourses = 0; // count of courses we can complete
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            completedCourses++;
            
            // For each course that depends on currentCourse, reduce its indegree
            for (int dependentCourse : graph[currentCourse]) {
                indegree[dependentCourse]--;
                // If indegree becomes 0, it can now be taken
                if (indegree[dependentCourse] == 0) {
                    queue.offer(dependentCourse);
                }
            }
        }
        
        // Step 4: Check if all courses can be completed
        // If completedCourses == numCourses, no cycle, all courses can be finished
        return completedCourses == numCourses;
    }
    
    // Method to get the topological order if needed
    public static List<Integer> getTopologicalOrder(int numCourses, int[][] prerequisites) {
        // Similar setup as above
        int[] indegree = new int[numCourses];
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int prereqCourse = prereq[1];
            graph[prereqCourse].add(course);
            indegree[course]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        List<Integer> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            order.add(currentCourse);
            
            for (int dependentCourse : graph[currentCourse]) {
                indegree[dependentCourse]--;
                if (indegree[dependentCourse] == 0) {
                    queue.offer(dependentCourse);
                }
            }
        }
        
        // If order size != numCourses, there's a cycle, return empty list
        if (order.size() != numCourses) {
            return new ArrayList<>();
        }
        return order;
    }
    
    // Main method for testing
    public static void main(String[] args) {
        // Example: 4 courses with prerequisites
        // Course 1 and 2 require course 0
        // Course 3 requires both course 1 and 2
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        
        boolean canFinish = canFinish(numCourses, prerequisites);
        System.out.println("Can finish all courses: " + canFinish);
        
        List<Integer> order = getTopologicalOrder(numCourses, prerequisites);
        System.out.println("Topological order: " + order);
    }
}
