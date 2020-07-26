class Solution:
    def searchInsert(self, nums, target):
        for i in range(len(nums)):
            if target == nums[i]:
                return i
            elif nums[i] > target:
                return i
            if i == len(nums)-1:
                return i+1


s = Solution()
print(s.searchInsert([1, 3, 5, 6], 5))
