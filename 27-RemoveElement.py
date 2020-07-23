class Solution:
    def removeElement(self, nums, val):
        i, j = len(nums)-1, len(nums)-1
        while i >= 0:
            if nums[i] == val:
                nums[i], nums[j] = nums[j], nums[i]
                j -= 1
            i -= 1
        return j+1


s = Solution()
print(s.removeElement([0, 1, 2, 2, 3, 0, 4, 2], 2))
