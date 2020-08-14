class Solution:
    def threeSumClosest(self, nums, target):
        n = len(nums)
        nums.sort()
        ans = float("inf")
        for i in range(n):
            l, r = i+1, n-1
            while l < r:
                currSum = nums[i]+nums[l]+nums[r]
                if currSum == target:
                    return currSum
                if abs(currSum-target) < abs(ans-target):
                    ans = currSum
                if currSum < target:
                    l += 1
                else:
                    r -= 1
        return ans


s = Solution()
print(s.threeSumClosest([-1, 2, 1, -4], 1))
