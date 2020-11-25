class Solution:
    # Solution 1 - Recursion
    # def rob(self, nums):
    #     return self.solve(nums, len(nums)-1)
    
    # def solve(self, nums, i):
    #     if i<0:
    #         return 0
    #     return max(self.solve(nums, i-2)+nums[i], self.solve(nums, i-1))

    # Solution 2 - Recursive + memo (Top-Down)
    # def rob(self, nums):
    #     dp = [-1 for _ in range(len(nums)+1)]
    #     return self.solve(nums, len(nums)-1, dp)
    
    # def solve(self, nums, i, dp):
    #     if i<0:
    #         return 0
    #     if dp[i]>=0:
    #         return dp[i]
    #     ans = max(self.solve(nums, i-2, dp)+nums[i], self.solve(nums, i-1, dp))
    #     dp[i] = ans
    #     return ans

    # Solution 3 - Iterative + memo (Bottom-Up)
    # def rob(self, nums):
    #     n = len(nums)
    #     if not n:
    #         return 0
    #     dp = [0 for i in range(n+1)]
    #     dp[1] = nums[0]
    #     for i in range(1, n):
    #         ans = nums[i]
    #         dp[i+1] = max(dp[i], dp[i-1]+ans)
    #     return dp[n]
    
    # Solution 4 - Iterative + 2 Variables (Bottom-Up)
    def rob(self, nums):
        n = len(nums)
        if not n:
            return 0
        prev1 = prev2 = 0
        for i in nums:
            temp = prev1
            prev1 = max(prev2+i, prev1)
            prev2 = temp
        return prev1


s = Solution()
print(s.rob([2,7,9,3,1]))