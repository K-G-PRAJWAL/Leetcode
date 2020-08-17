# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


# DFS - Recursive - 91.37% Time | 86.38% Space
class Solution:
    def hasPathSum(self, root: TreeNode, sum: int) -> bool:
        ans = []
        self.dfsHelper(root, sum, ans)
        if True in ans:
            return True
        else:
            return False

    def dfsHelper(self, root, sum, ans):
        if root:
            if not root.left and not root.right and root.val == sum:
                ans.append(True)
            if root.left:
                self.dfsHelper(root.left, sum-root.val, ans)
            if root.right:
                self.dfsHelper(root.right, sum - root.val, ans)
            print(root.val)


# DFS - Iterative - 91.37% Time | 14.50% Space
class Solution:
    def hasPathSum(self, root: TreeNode, sum: int) -> bool:
        if not root:
            return False
        stck = [[root, root.val]]
        while stck:
            ptr, num = stck.pop()
            if not ptr.left and not ptr.right and num == sum:
                return True
            if ptr.left:
                stck.append([ptr.left, num+ptr.left.val])
            if ptr.right:
                stck.append([ptr.right, num+ptr.right.val])
        return False


# BFS - Iterative - 91.37% Time | 88.29% Space
class Solution:
    def hasPathSum(self, root: TreeNode, sum: int) -> bool:
        if not root:
            return False
        q = [[root, sum-root.val]]
        while q:
            ptr, num = q.pop(0)
            if not ptr.left and not ptr.right and num == 0:
                return True
            if ptr.left:
                q.append([ptr.left, num-ptr.left.val])
            if ptr.right:
                q.append([ptr.right, num-ptr.right.val])
        return False
