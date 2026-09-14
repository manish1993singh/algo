class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class LinkedList:
    def __init__(self):
        self.head = None

    def append(self,data):
        node = Node(data)
        if not self.head:
            self.head = node
            return self

        current = self.head
        while current.next:
            current = current.next
        
        current.next = node
        return self

def has_cycle(node: Node):
    fast = node
    slow = node
    while fast != None and fast.next != None:
        fast = fast.next.next
        slow = slow.next
        if fast == slow:
            return True
    return False

ll = LinkedList()
ll.append(10)
ll.append(20)
ll.append(30)
ll.append(40)

print(has_cycle(ll.head))