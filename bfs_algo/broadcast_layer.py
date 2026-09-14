## Problem 26: Binary Tree Broadcast Layering
# Difficulty: Easy/Medium
# Pattern 26: Queue BFS (Level Order Traversal)
# Problem Statement:
# You are mapping out a corporate routing topology structured as a Binary Tree. 
# Given the root node of this binary tree, return the level order traversal of its nodes' values. 
# (i.e., from left to right, level by level).
# TreeNode Definition (for reference):

# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Example 1:

# * Input: root = [3, 9, 20, null, null, 15, 7]
# * Output: ``

# Example 2:

# * Input: root = [1]
# * Output: ``

# Example 3:

# * Input: root = []
# * Output: []

# Constraints:

# * The number of nodes in the tree is in the range [0, 2000].
# * -1000 <= TreeNode.val <= 1000


from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def prep_tree(arr: list[int], i:int) -> TreeNode:
    if i >= len(arr) or arr[i] is None:
        return None
    root = arr[i]
    left = prep_tree(arr, 2*i + 1)
    right = prep_tree(arr, 2*i + 2)
    return TreeNode(root, left, right)

def traverse(node: TreeNode) -> list[list[int]]:
    if not node:
        return []
    result = []
    queue = deque([node])
    while queue:
        level_size = len(queue)
        level_values = []
        for i in range(level_size):
            current = queue.popleft()
            level_values.append(current.val)
            if current.left:
                queue.append(current.left)
            if current.right:
                queue.append(current.right)
        result.append(level_values)
    return result

tree = prep_tree([3, 9, 20, None, None, 15, 7], 0)

print(traverse(tree))


        