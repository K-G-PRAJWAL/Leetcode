# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def traverse_tree(self, root, ans):
        if root:
            ans.append(root.val)
            self.traverse_tree(root.left, ans)
            self.traverse_tree(root.right, ans)
        return ans

    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        ans = []
        self.traverse_tree(root, ans)
        return ans
