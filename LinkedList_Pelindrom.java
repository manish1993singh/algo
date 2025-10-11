
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class LinkedList_Pelindrom {
    public int lPalin(ListNode A) {
        ListNode slow = A, fast = A;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode secondHalf = reverse(slow);
        ListNode firstHalf = A;
        while( secondHalf != null){
            if(firstHalf.val != secondHalf.val){
                return 0;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return 1;
    }
    
    public ListNode reverse(ListNode A){
        ListNode current = A;
        ListNode previous = null;
        
        while(current != null){
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        
        return previous;
    }

    public static void main(String[] args){
        ListNode current = new ListNode(1);
        current.next = new ListNode(2);
        current.next.next = new ListNode(1);
        // current.next.next.next = new ListNode(1);

        int result = new LinkedList_Pelindrom().lPalin(current);
        System.out.print(result);
    }
}
