package java_basics;

import java.util.Queue;

public class Queue_ {
    // Queue is a linear data structure that follows the FIFO (First In First Out) principle.
    // Elements are added at the rear and removed from the front.
    // Common operations: enqueue (add), dequeue (remove), peek (view front element), isEmpty, size.

    // Java provides Queue interface and several implementations like LinkedList, PriorityQueue, etc.

    public static void main(String[] args){
        // Example usage of Queue can be added here
    Queue<Integer> queue = new java.util.LinkedList<>();
        queue.add(1); // Enqueue
        queue.add(2);
        queue.add(3);
        System.out.println("Queue size: " + queue.size());
        System.out.println("Front element: " + queue.peek()); // Peek
        System.out.println("Queue size: " + queue.size());
        System.out.println("Dequeue: " + queue.poll()); // Dequeue
        System.out.println("Is queue empty? " + queue.isEmpty()); // Check if empty
        System.out.println("Queue size: " + queue.size()); // Size of the queue
    }    
}
