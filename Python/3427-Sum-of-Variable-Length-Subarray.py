class Solution:
    def subarraySum(self, nums: List[int]) -> int:
        n = len(nums)
        sub = []
        for i in range(n):
            x = nums[max(0, i - nums[i]):i+1]
            sub.append(sum(x))
        return sum(sub)