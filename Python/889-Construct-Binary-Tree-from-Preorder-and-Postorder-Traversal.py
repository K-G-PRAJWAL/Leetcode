# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    prei = 0
    posti = 0
    def constructFromPrePost(self, preorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        root = TreeNode(preorder[self.prei])

        self.prei += 1
        if root.val != postorder[self.posti]:
            root.left = self.constructFromPrePost(preorder, postorder)
        if root.val != postorder[self.posti]:
            root.right = self.constructFromPrePost(preorder, postorder)
        self.posti+=1

        return root

    def constructFromPrePost(self, preorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        stack = [TreeNode(preorder[0])]
        i = 0

        for n in preorder[1:]:
            node = TreeNode(n)
            while stack[-1].val == postorder[i]:
                stack.pop()
                i += 1
            if not stack[-1].left:
                stack[-1].left = node
            else:
                stack[-1].right = node
            stack.append(node)

        return stack[0]