class Solution:
    def dfs(self, nums, ans, idx, temp):

        if len(temp) > 1:
            ans.add(tuple(temp))

        if idx == len(nums):
            return

        if (not temp) or (nums[idx] >= temp[-1]):
            self.dfs(nums, ans, idx+1, temp+[nums[idx]])

        self.dfs(nums, ans, idx+1, temp)
        return ans

    def findSubsequences(self, nums: List[int]) -> List[List[int]]:
        return set(self.dfs(nums, set(), 0, []))
