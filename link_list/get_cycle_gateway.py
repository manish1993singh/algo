## Problem 30: Network Cycle Gateway
# Difficulty: Medium
# Pattern 30: Linked List — Fast & Slow Pointer (Floyd's Cycle Detection II)
# Problem Statement:
# Given the head of a singly linked list representing a network routing path, return the exact node where the cycle begins. If there is no cycle, return None.
# To prevent modifying the original layout, you must not alter the nodes in the list. You must solve this using $O(1)$ extra space.
# Example 1:

# * Input: head = [3, 2, 0, -4], cycle points back to node index 1 (value 2)
# * Output: Node reference with value 2

# Example 2:

# * Input: head =, no cycle
# * Output: None

# Constraints:

# * The number of nodes in the list is in the range [0, 10⁴].
# * -10⁵ <= Node.val <= 10⁵

class Node:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def gateway(head: Node):
    fast = head
    slow = head

    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next

        if fast == slow:
            slow = head
            while fast != slow:
                fast = fast.next
                slow = slow.next

            return fast
    return None


# Test Cases
if __name__ == "__main__":
    # Test Case 1: Cycle at position 1 (value 2)
    # List: 3 -> 2 -> 0 -> -4 -> 2 (cycle back to index 1)
    node1 = Node(3)
    node2 = Node(2)
    node3 = Node(0)
    node4 = Node(-4)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node2  # cycle points to node2
    
    result1 = gateway(node1)
    print(f"Test 1 - Cycle starts at node with value: {result1.val if result1 else None}")
    assert result1 == node2, "Expected node with value 2"
    
    # Test Case 2: No cycle
    # List: 1 -> 2 -> 3 -> 4
    node1_no_cycle = Node(1)
    node2_no_cycle = Node(2)
    node3_no_cycle = Node(3)
    node4_no_cycle = Node(4)
    node1_no_cycle.next = node2_no_cycle
    node2_no_cycle.next = node3_no_cycle
    node3_no_cycle.next = node4_no_cycle
    
    result2 = gateway(node1_no_cycle)
    print(f"Test 2 - No cycle: {result2}")
    assert result2 is None, "Expected None"
    
    # Test Case 3: Cycle at head (single node cycle)
    # List: 5 -> 5 (self-loop)
    node_self = Node(5)
    node_self.next = node_self
    
    result3 = gateway(node_self)
    print(f"Test 3 - Self-loop cycle at: {result3.val if result3 else None}")
    assert result3 == node_self, "Expected node with value 5"
    
    # Test Case 4: Cycle at end
    # List: 1 -> 2 -> 3 -> 4 -> 3 (cycle back to position 2)
    node1_end = Node(1)
    node2_end = Node(2)
    node3_end = Node(3)
    node4_end = Node(4)
    node1_end.next = node2_end
    node2_end.next = node3_end
    node3_end.next = node4_end
    node4_end.next = node3_end
    
    result4 = gateway(node1_end)
    print(f"Test 4 - Cycle starts at node with value: {result4.val if result4 else None}")
    assert result4 == node3_end, "Expected node with value 3"
    
    # Test Case 5: Single node, no cycle
    single_node = Node(10)
    result5 = gateway(single_node)
    print(f"Test 5 - Single node no cycle: {result5}")
    assert result5 is None, "Expected None"
    
    # Test Case 6: Two nodes with cycle
    # List: 1 -> 2 -> 1
    node1_two = Node(1)
    node2_two = Node(2)
    node1_two.next = node2_two
    node2_two.next = node1_two
    
    result6 = gateway(node1_two)
    print(f"Test 6 - Cycle starts at node with value: {result6.val if result6 else None}")
    assert result6 == node1_two, "Expected node with value 1"
    
    print("\nAll tests passed! ✓")

