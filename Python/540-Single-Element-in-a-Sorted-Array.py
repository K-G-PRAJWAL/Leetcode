class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]

        l = 0
        r = len(nums)-1

        while l <= r:
            if nums[l] == nums[l+1]:
                l += 2
            else:
                return nums[l]
            if nums[r] == nums[r-1]:
                r -= 2
            else:
                return nums[r]

        # Another approach
        l, r = 0, len(nums) - 1
        while l < r:
            m = (l + r) // 2
            if m % 2 == 1:
                m -= 1
            if nums[m] != nums[m + 1]:
                r = m
            else:
                l = m + 2
        return nums[l]
