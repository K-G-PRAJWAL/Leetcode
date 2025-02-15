class Solution:
    def sumOfGoodNumbers(self, nums: List[int], k: int) -> int:
        n = len(nums)

        good = 0
        for i in range(n):
            check = True
            if i - k >= 0 and nums[i] <= nums[i-k]:
                check = False
            if i+k < n and nums[i] <= nums[i+k]:
                check = False
            if check:
                good += nums[i]

        return good