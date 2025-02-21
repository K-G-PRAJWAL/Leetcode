# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class FindElements:

    def __init__(self, root: Optional[TreeNode]):
        self.visited = set()
        self.dfs(root, 0)

    def find(self, target: int) -> bool:
        return target in self.visited

    def dfs(self, curr_node, curr_val):
        if curr_node is None:
            return
        self.visited.add(curr_val)
        self.dfs(curr_node.left, curr_val*2+1)
        self.dfs(curr_node.right, curr_val*2+2)

# Your FindElements object will be instantiated and called as such:
# obj = FindElements(root)
# param_1 = obj.find(target)