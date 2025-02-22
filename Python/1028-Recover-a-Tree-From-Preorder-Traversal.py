# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverFromPreorder(self, traversal: str) -> Optional[TreeNode]:
        stack = []
        idx = 0

        while idx < len(traversal):
            depth = 0

            while idx < len(traversal) and traversal[idx] == '-':
                depth += 1
                idx += 1

            n = 0
            while idx < len(traversal) and traversal[idx].isdigit():
                n = n*10+int(traversal[idx])
                idx += 1

            node = TreeNode(n)

            while len(stack) > depth:
                stack.pop()

            if stack:
                if not stack[-1].left:
                    stack[-1].left = node
                else:
                    stack[-1].right = node

            stack.append(node)

        return stack[0] if stack else None