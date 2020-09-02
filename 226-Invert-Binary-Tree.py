# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque


class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        # Recursive
        if not root:
            return None
        root.left, root.right = self.invertTree(
            root.right), self.invertTree(root.left)
        return root

        # BFS
        if not root:
            return None
        q = deque([(root)])
        while q:
            curr = q.popleft()
            if curr:
                curr.left, curr.right = curr.right, curr.left
                q.append(curr.left)
                q.append(curr.right)
        return root

        # DFS (Fastest)
        stck = [root]
        while stck:
            curr = stck.pop()
            if curr:
                curr.left, curr.right = curr.right, curr.left
                stck.extend([curr.right, curr.left])
        return root
