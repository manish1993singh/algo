class Node:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def prepare(nodes:list[int], i = 0) -> Node:
    if i >= len(nodes):
        return
    root = nodes[i]
    left = prepare(nodes,i*2+1)
    right = prepare(nodes, i*2+2)
    return Node(root, left, right)


arr = [1,2,3,4,5,6,7,8,9]

root = prepare(arr, 0)
print(root.val)

from collections import deque

def inorder_iterative(root:Node) -> list[int]:
    result, stack = [], []
    curr = root
    while curr or stack:
        while curr:
            stack.append(curr)
            curr = curr.left
        curr = stack.pop()
        result.append(curr.val)
        curr = curr.right
    return result            

def inorder_recurcive(root:Node):
    if not root:
        return []
    return inorder_recurcive(root.left) + [root.val] + inorder_recurcive(root.right)

def preorder_recurcive(root:Node):
    if not root:
        return []
    return [root.val]+preorder_recurcive(root.left)+preorder_recurcive(root.right)

def postorder_recurcive(root:Node):
    if not root:
        return []
    return postorder_recurcive(root.left)+postorder_recurcive(root.right)+[root.val]

def levelorder_iteration(root:Node):
    dq = deque([root])
    result = []
    while dq:
        level_size = len(dq)
        level_result = []
        for i in range(level_size):
            curr = dq.popleft()
            level_result.append(curr.val)
            if curr.left: dq.append(curr.left)
            if curr.right: dq.append(curr.right)
        result.append(level_result)
    return result

print(inorder_recurcive(root))
print(inorder_iterative(root))

print(preorder_recurcive(root))
print(postorder_recurcive(root))

print(levelorder_iteration(root))


