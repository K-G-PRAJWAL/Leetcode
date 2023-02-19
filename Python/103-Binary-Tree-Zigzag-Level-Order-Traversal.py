# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        q = deque([root])
        lvl = 0
        ans = []

        while q:
            curr_q = deque()
            lvl_size = len(q)

            for i in range(lvl_size):
                node = q.popleft()
                if lvl % 2 == 0:
                    curr_q.append(node.val)
                else:
                    curr_q.appendleft(node.val)

                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)

            ans.append(curr_q)
            lvl += 1

        return ans
