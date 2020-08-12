# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


# Recursive Solution
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root is None:
            return True
        else:
            return self.Check(root.left, root.right)

    def Check(self, left, right):
        if left is None and right is None:
            return True
        if left is None or right is None:
            return False
        if left.val == right.val:
            outerTree = self.Check(left.left, right.right)
            innerTree = self.Check(left.right, right.left)
            return outerTree and innerTree
        else:
            return False


# Iterative Solution
class Solution:
    def isSymmetric(self, root):
        if root is None:
            return True
        else:
            stack = [[root.left, root.right]]

        while stack:
            left, right = stack.pop()
            if left is None and right is None:
                continue
            if left is None or right is None:
                return False
            if left.val == right.val:
                stack.insert(0, [left.left, right.right])
                stack.insert(0, [left.right, right.left])
            else:
                return False
        return True
