class Solution:
    def applyOperations(self, nums: List[int]) -> List[int]:
        n = len(nums)

        for i in range(n-1):
            if nums[i]==nums[i+1]:
                nums[i] *= 2
                nums[i+1] = 0

        l = 0
        for i in range(n):
            if nums[i]:
                nums[i], nums[l] = nums[l], nums[i]
                l+=1

        return nums