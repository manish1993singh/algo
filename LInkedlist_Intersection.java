

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LInkedlist_Intersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pointerA = headA;
        ListNode pointerB = headB;

        // Traverse both lists. When one pointer reaches the end, move it to the other list's head.
        while (pointerA != pointerB) {
            pointerA = (pointerA == null) ? headB : pointerA.next;
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }

        // Either they meet at the intersection point or at null if there's no intersection.
        return pointerA;
    }

    public static void main(String[] args) {
        // Test case setup
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        ListNode intersection = new ListNode(3);
        headA.next.next = intersection;
        intersection.next = new ListNode(4);
        intersection.next.next = new ListNode(5);

        ListNode headB = new ListNode(6);
        headB.next = new ListNode(7);
        headB.next.next = new ListNode(8);
        headB.next.next.next = new ListNode(9);
        headB.next.next.next.next = intersection;

        LInkedlist_Intersection solution = new LInkedlist_Intersection();
        ListNode result = solution.getIntersectionNode(headA, headB);
        if (result != null) {
            System.out.println("Intersection Node Value: " + result.val);
        } else {
            System.out.println("No Intersection.");
        }
    }
}
