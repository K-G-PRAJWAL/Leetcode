import collections

class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

class Solution:
    def findLeaves(self, root):
        d = collections.defaultdict(list)
        self.solve(root, d)
        ans = []
        for i in sorted(d.keys()):
            ans.append(d[i])
        return ans
    
    def solve(self, root, d):
        if not root:
            return 0
        left = self.solve(root.left, d)
        right = self.solve(root.right, d)
        lvl = 1+max(left, right)
        d[lvl].append(root.val)
        return lvl


node1 = TreeNode(1)
node2 = TreeNode(2)
node3 = TreeNode(3)
node4 = TreeNode(4)
node5 = TreeNode(5)
node1.left = node2
node1.right = node3
node2.left = node4
node2.right = node5
s = Solution()
print(s.findLeaves(node1))