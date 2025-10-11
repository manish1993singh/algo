

//Definition for singly-linked list.
 public class Binary_Linkedlist {
    public ListNode solve(ListNode A) {
        //traverse the list to count 0's and 1s
        //override node values
        
        ListNode current = A;
        int countZero = 0;
        int countOne = 0;
        while(current != null){
            int value = current.val;
            if(value == 0){
                countZero++;
            }else{
                countOne++;
            }
            current = current.next;
        }
        
        current = A;
        while(current != null){
            if(countZero > 0){
                current.val = 0;
                current = current.next;
                countZero--;
            }else if(countOne > 0){
                current.val = 1;
                current = current.next;
                countOne--;
            }
        }
        return A;
    }

    public static void main(String[] args){
        ListNode current = new ListNode(0);
        current.next = new ListNode(1);
        current.next.next = new ListNode(0);
        current.next.next.next = new ListNode(1);

        ListNode result = new Binary_Linkedlist().solve(current);
        while(result != null){
            System.out.print(result.val+"->");
            result = result.next;
        }
    }
}
