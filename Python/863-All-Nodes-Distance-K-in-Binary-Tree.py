# Definition for a binary tree node.
from collections import deque

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def distanceK(self, root, target, K):
        parents = {}
        def dfs(curr, parent):
            parents[curr] = parent
            if curr.left:
                dfs(curr.left, curr)
            if curr.right:
                dfs(curr.right, curr)
        dfs(root, None)
        
        q = deque([(target, 0)])
        visited = {target}
        while q:
            curr, distance = q.popleft()
            if distance==K:
                return [curr.val]+[node.val for node, dist in q]
            for node in (curr.left, curr.right, parents[curr]):
                if node and node not in visited:
                    visited.add(node)
                    q.append((node, distance+1))
        return []


node1 = TreeNode(3)
node2 = TreeNode(5)
node3 = TreeNode(1)
node4 = TreeNode(6)
node5 = TreeNode(2)
node6 = TreeNode(0)
node7 = TreeNode(8)
node8 = TreeNode(7)
node9 = TreeNode(4)
node1.left = node2
node1.right = node3
node2.left = node4
node2.right = node5
node3.left = node6
node3.right = node7
node5.left = node8
node5.right = node9
s = Solution()
print(s.distanceK(node1, node2, 2))