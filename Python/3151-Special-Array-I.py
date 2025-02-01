class Solution:
    def isArraySpecial(self, nums: List[int]) -> bool:
        n = len(nums)

        for i in range(n-1):
            if nums[i] % 2 == 0 and nums[i+1] % 2 == 1:
                continue
            elif nums[i] % 2 == 1 and nums[i+1] % 2 == 0:
                continue
            else:
                return False

        return True

    def isArraySpecial_bit(self, nums):
        n = len(nums)

        for i in range(n-1):
            if (nums[i]&1) ^ (nums[i+1]&1) == 0:
                return False

        return True