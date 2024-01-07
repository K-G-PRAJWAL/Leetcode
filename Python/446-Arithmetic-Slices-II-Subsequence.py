from collections import defaultdict


class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [defaultdict(int) for _ in range(n)]

        ans = 0
        for i in range(n):
            for j in range(i):
                diff = nums[i] - nums[j]
                dp[i][diff] += dp[j][diff]+1
                ans+= dp[j][diff]
        
        return ans