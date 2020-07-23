class Solution:
    def twoSum(self, nums, target):
        diff = {}
        for i in range(len(nums)):
            d = target - nums[i]
            if nums[i] in diff:
                return [diff[nums[i]], i]
            else:
                diff[d] = i


s = Solution()
print(s.twoSum([2, 11, 7, 15], 9))
