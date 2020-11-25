# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def levelOrderBottom(self, root: TreeNode) -> List[List[int]]:
        ans = []
        if root is None:
            return ans
        q = []
        q.append(root)
        while q:
            nodeCount = len(q)
            row = []
            while nodeCount:
                currNode = q.pop(0)
                if currNode.left:
                    q.append(currNode.left)
                if currNode.right:
                    q.append(currNode.right)
                row.append(currNode.val)
                nodeCount -= 1
            ans.insert(0, row)
        return ans
