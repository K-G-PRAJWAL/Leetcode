class Solution:
    def maxSubArray(self, nums):  # Kadane's Algorithm
        globalMax = nums[0]
        localMax = nums[0]
        for i in range(1, len(nums)):
            localMax = max(localMax+nums[i], nums[i])
            globalMax = max(globalMax, localMax)
        return globalMax


s = Solution()
print(s.maxSubArray([-2, 1, -3, 4, -1, 2, 1, -5, 4]))
