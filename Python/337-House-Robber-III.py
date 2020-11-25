# Definition for a binary tree node.

from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def rob(self, root):
        return max(self.solve(root))
    
    def solve(self, curr):
        if not curr:
            return (0, 0)
        left, right = self.solve(curr.left), self.solve(curr.right)
        currHouse = curr.val+left[1]+right[1]
        nextHouse = max(left)+max(right)
        return (currHouse, nextHouse)



root = TreeNode(3)
node1 = TreeNode(2)
node2 = TreeNode(3)
node3 = TreeNode(3)
node4 = TreeNode(1)
root.left = node1
root.right=node2
node1.right=node3
node2.right=node4
s = Solution()
print(s.rob(root))