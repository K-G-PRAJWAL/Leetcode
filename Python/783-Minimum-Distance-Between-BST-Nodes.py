# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minDiffInBST(self, root: Optional[TreeNode]) -> int:
        prev = None
        ans = float('inf')

        def dfs(node):
            if not node:
                return

            dfs(node.left)

            nonlocal prev, ans

            if prev:
                ans = min(ans, node.val - prev.val)
            prev = node
            dfs(node.right)

        dfs(root)
        return ans
