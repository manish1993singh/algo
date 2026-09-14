# ## Problem 12: Find the Server Cycle
# Difficulty: Easy
# Pattern 12: Fast & Slow Pointers (Floyd's Cycle Detection)
# Problem Statement:
# You are tracking a token being passed through a network of servers represented as a singly linked list. Each node points to the next server. However, due to a routing misconfiguration, the final server might point back to an earlier server in the chain, causing an infinite loop.
# Determine if the linked list has a cycle in it.
# Example 1:

# * Input: head = [3, 2, 0, -4], cycle back to index 1 (value 2)
# * Output: True

# Example 2:

# * Input: head = [1], no cycle
# * Output: False


class Node:
    def __init__(self, val= 0, next:None= None):
        self.val = val
        self.next = next


def has_cycle(node: Node) -> bool:
    fast = node
    slow = node
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
        if fast == slow:
            return True
        
        
    return False


head = Node(3)
second = Node(2)
third = Node(0)
fourth = Node(-4)

head.next = second
second.next = third
third.next = fourth
# fourth.next = second

print(has_cycle(head))