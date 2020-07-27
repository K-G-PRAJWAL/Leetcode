class Solution:
    def removeDuplicates(self, nums):
        if len(nums) == 0:
            return 0
        i, j = 0, 1
        while j < len(nums):
            if nums[i] != nums[j]:
                i += 1
                nums[i] = nums[j]
            j += 1
        x = i+1
        while x != len(nums):
            del nums[x]
        return i+1


s = Solution()
print(s.removeDuplicates([0, 0, 1, 1, 1, 2, 2, 3, 3, 4]))
