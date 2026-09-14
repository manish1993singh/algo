# ## Problem 14: Remove the K-th Node From End
# Difficulty: Medium
# Pattern 14: Two Pointers (Intersection/K-th / Offset)
# Problem Statement:
# You are managing an execution pipeline represented as a singly linked list. You need to remove the n-th node from the end of the list and return its head.
# You must perform this optimization in a single pass over the list.
# Example 1:

# * Input: head = 1 -> 2 -> 3 -> 4 -> 5, n = 2
# * Output: 1 -> 2 -> 3 -> 5
# * Explanation: The second node from the end is 4. Removing it gives 1 -> 2 -> 3 -> 5.

# Example 2:

# * Input: head = 1, n = 1
# * Output: []

# Example 3:

# * Input: head = 1 -> 2, n = 1
# * Output: 1

# Constraints:

# * The number of nodes in the list is sz.
# * 1 <= sz <= 30
# * 0 <= Node.val <= 100
# * 1 <= n <= sz

from __future__ import annotations
class Node:
    def __init__(self, val=0, next:Node = None):
        self.val = val
        self.next = next

def remove(node:Node, n)->Node:

    last = node
    counter = 1
    # instead of two while loops, lets use two pointers separated by n
    while last.next:
        last = last.next
        counter += 1

    before_target = node
    while counter - n -1:
        before_target = before_target.next
        counter -= 1

    target = before_target.next
    before_target.next = target.next
    return node


def remove_2(node:Node, n)->Node:
    dummy = Node()
    dummy.next = node
    lead = dummy
    lag = dummy
    counter = 0
    while lead.next:
        lead = lead.next
        counter += 1
        if counter > n:
            lag = lag.next

    lag.next = lag.next.next
    return dummy.next

def pri(node:Node):
    while node:
        print(node.val)
        node = node.next


head = Node(1,Node(2, Node(3, Node(4, Node(5)))))
# pri(head)
head = remove_2(head,1)
pri(head)

    