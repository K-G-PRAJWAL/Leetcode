class Solution:
    def maxAdjacentDistance(self, nums: List[int]) -> int:
        maxi = float("-inf")
        for i in range(1, len(nums)):
            print(maxi, nums[i], nums[i-1])
            maxi = max(maxi, abs(nums[i] - nums[i-1]))

        return max(maxi, abs(nums[len(nums)-1] - nums[0]))


        return max(abs(nums[i] - nums[(i+1)%len(nums)]) for i in range(len(nums)))