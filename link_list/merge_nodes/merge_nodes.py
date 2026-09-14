class Node:
    def __init__(self, val = 0, next = None):
        self.val = val
        self.next = next

def merge(node1: Node, node2: Node) -> Node:
    dummy = Node()
    current = dummy
    while node1 and node2:
        if node1.val <= node2.val:
            current.next = node1
            node1 = node1.next
        else:
            current.next = node2
            node2 = node2.next
        current = current.next

    current.next = node1 or node2
    return dummy.next


list1 = Node(1, Node(2, Node(4)))
list2 = Node(1, Node(3, Node(4)))
expected = "1 -> 1 -> 2 -> 3 -> 4 -> 4"
merged = merge(list1, list2)

actual_values = []
while merged:
    actual_values.append(str(merged.val))
    merged = merged.next
actual = " -> ".join(actual_values)

print(f"Input: list1 = 1 -> 2 -> 4, list2 = 1 -> 3 -> 4")
print(f"Output: {actual}")
print(f"Expected output: {expected}")
print(f"Matches expected: {actual == expected}")
