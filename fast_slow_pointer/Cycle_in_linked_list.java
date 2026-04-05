package fast_slow_pointer;

import java.util.List;

public class Cycle_in_linked_list {

    static class Node{
        int data;
        Node next;
        Node(int x){
            data = x;
            next = null;
        }
    }
    private static boolean hasCycle(Node head){
        if (head == null) return false;
        
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        // Test Case 1: List with a cycle
        Node head1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(0);
        Node node4 = new Node(-4);
        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Creates cycle back to node2
        System.out.println(hasCycle(head1)); // Should print false
    }
}
