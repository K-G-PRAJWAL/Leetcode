class Solution:
    def rob(self, nums):
        if len(nums)<=2:
            return max([0]+nums)
        return max(self.solve(nums[1:]), self.solve(nums[:-1]))
    
    def solve(self, nums):
        n = len(nums)
        if not n:
            return 0
        prev1 = prev2 = 0
        for i in nums:
            prev1, prev2 = max(prev2+i, prev1), prev1
        return prev1

s = Solution()
print(s.rob([1,2,3,1]))