# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minDepth(self, root):
        # DFS
        if root is None:
            return 0
        if None in [root.left, root.right]:
            return max(self.minDepth(root.left)+1, self.minDepth(root.right)+1)
        else:
            return min(self.minDepth(root.left)+1, self.minDepth(root.right)+1)

        # BFS
        if not root:
            return 0
        q = deque([root, 1])
        while q:
            node, lvl = q.popleft()
            if node:
                if not node.left and not node.right:
                    return lvl
                else:
                    q.append([node.left, lvl+1])
                    q.append([node.right, lvl+1])
