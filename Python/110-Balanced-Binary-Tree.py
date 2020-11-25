# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        if root is None:
            return True
        return self.getHeight(root) != -1

    def getHeight(self, node):
        if node is None:
            return 0
        left = self.getHeight(node.left)
        right = self.getHeight(node.right)
        if left == -1 or right == -1 or abs(left-right) > 1:
            return -1
        return 1+max(left, right)
