# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    # Solution 1 - slicing
    def sortedArrayToBST(self, nums):
        if not nums:
            return None
        mid = len(nums)//2
        root = TreeNode(nums[mid])
        root.left = self.sortedArrayToBST(nums[:mid])
        root.right = self.sortedArrayToBST(nums[mid+1:])
        return root

    # Solution 2 - No Slicing
    def sortedArrayToBST(self, nums):
        return self.solve(nums, 0, len(nums))

    def solve(self, nums, l, u):
        if l == u:
            return None
        mid = (l+u)//2
        root = TreeNode(nums[mid])
        root.left = self.solve(nums, l, mid)
        root.right = self.solve(nums, mid+1, u)
        return root
