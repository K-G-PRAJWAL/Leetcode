# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def findDuplicateSubtrees(self, root: Optional[TreeNode]) -> List[Optional[TreeNode]]:
        subtrees = collections.defaultdict(list)

        def preorder(node):
            if not node:
                return "None"
            serialized = ",".join(
                [str(node.val), preorder(node.left), preorder(node.right)])
            if len(subtrees[serialized]) == 1:
                ans.append(node)
            subtrees[serialized].append(node)
            return serialized

        ans = []
        preorder(root)

        return ans
