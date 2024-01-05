class Solution:
    def maximumJumps(self, nums: List[int], target: int) -> int:
        n = len(nums)
        dp = [-1] * n
        dp[0] = 0

        for i in range(1, n):
            for j in range(i):
                if abs(nums[j] - nums[i])<=target and dp[j]!=-1:
                    dp[i] = max(dp[i], dp[j]+1)
        
        return dp[n-1]