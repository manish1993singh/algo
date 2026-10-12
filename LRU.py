class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None


class LRU:
    def __init__(self, capacity):
        self.capacity = capacity
        self.cache = {}

        self.head = Node(0, 0)
        self.tail = Node(0, 0)
        self.head.next = self.tail
        self.tail.prev = self.head

    def insert(self, node: Node):
        node.prev = self.head
        node.next = self.head.next
        self.head.next.prev = node
        self.head.next = node

    def remove(self, node: Node):
        node.prev.next = node.next
        node.next.prev = node.prev

    def get(self, key):
        if key in self.cache:
            node = self.cache[key]
            self.remove(node)
            self.insert(node)
            return node.value
        return -1

    def put(self, key, value):
        if key in self.cache:
            self.remove(self.cache[key])
            del self.cache[key]

        node = Node(key, value)
        self.insert(node)
        self.cache[key] = node

        if len(self.cache) > self.capacity:
            lru = self.tail.prev
            self.remove(lru)
            del self.cache[lru.key]


if __name__ == "__main__":
    lru = LRU(2)
    lru.put(1, 10)
    lru.put(2, 20)
    print(lru.get(1))
    lru.put(3, 30)
    print(lru.get(2))
    print(lru.get(3))
