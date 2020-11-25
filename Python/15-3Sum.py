class Solution:
    def threeSum(self, nums):
        nums.sort()
        ans = []
        n = len(nums)
        for i in range(n):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            target = -nums[i]
            l, r = i+1, n-1
            while l < r:
                if nums[l]+nums[r] < target:
                    l += 1
                elif nums[l]+nums[r] > target:
                    r -= 1
                else:
                    ans.append((nums[i], nums[l], nums[r]))
                    l += 1
                    r -= 1
        return set(ans)


s = Solution()
print(s.threeSum([-1, 0, 1, 2, -1, -4]))
