# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    # Recursive Solution
    def maxDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        return max(self.maxDepth(root.left)+1, self.maxDepth(root.right)+1)

    # Iterative Solution
    def maxDepth(self, root):
        maxDepth = 0
        if root:
            currLevel = [root]
        else:
            currLevel = []
        while currLevel:
            maxDepth += 1
            q = []
            for val in currLevel:
                if val.left:
                    q.append(val.left)
                if val.right:
                    q.append(val.right)
            currLevel = q
        return maxDepth
