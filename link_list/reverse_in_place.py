from __future__ import annotations


## Problem 13: Reverse a Data Stream
# Difficulty: Easy
# Pattern 13: In-Place Reversal
# Problem Statement:
# Given the head of a singly linked list, reverse the list in-place (without using extra memory structures like arrays or stacks), and return the new head of the reversed list.
# Example 1:

# * Input: head = 1 -> 2 -> 3 -> 4 -> 5
# * Output: 5 -> 4 -> 3 -> 2 -> 1

# Example 2:

# * Input: head = 1 -> 2
# * Output: 2 -> 1

# Constraints:

# * The number of nodes in the list is the range [0, 5000].
# * -5000 <= Node.val <= 5000


class Node:
    def __init__(self, val=0, next: Node = None):
        self.val = val
        self.next = next

def reverse(node:Node)-> Node:
    previous = None
    current = node
    while current:
        next = current.next
        current.next = previous
        previous = current
        current = next
    return previous

def to_list(node: Node) -> list[int]:
    values = []
    while node:
        values.append(node.val)
        node = node.next
    return values


head = Node(1, Node(2, Node(3)))
print(f"Input: {to_list(head)}")
print(f"Output: {to_list(reverse(head))}")