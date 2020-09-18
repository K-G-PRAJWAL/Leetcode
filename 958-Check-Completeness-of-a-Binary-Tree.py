# Definition for a binary tree node.
from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isCompleteTree(self, root):
        # Solution 1
        nodeLevel = [(root, 1)]
        height = 0
        while height<len(nodeLevel):
            node, lvl = nodeLevel[height]
            height+=1
            if node:
                nodeLevel.append((node.left, 2*lvl))
                nodeLevel.append((node.right, 2*lvl+1))
        return nodeLevel[-1][1]==len(nodeLevel)
        
        # Solution 2
        q = deque()
        q.append(root)
        flag = False
        while q:
            curr = q.popleft()
            if not curr:
                flag = True
                continue
            elif flag:
                return False
            q.append(curr.left)
            q.append(curr.right)
        return True
            

node1 = TreeNode(1)
node2 = TreeNode(2)
node3 = TreeNode(3)
node4 = TreeNode(4)
node5 = TreeNode(5)
node6 = TreeNode(6)
node1.left = node2
node1.right = node3
node2.left = node4
node2.right = node5
node3.left = node6
s = Solution()
print(s.isCompleteTree(node1))