class Solution:
    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        local_max = -math.inf
        global_max = -math.inf

        local_min = math.inf
        global_min = math.inf

        sum = 0

        for i in range(len(nums)):
            local_max = max(local_max+nums[i], nums[i])
            global_max = max(global_max, local_max)

            local_min = min(local_min+nums[i], nums[i])
            global_min = min(global_min, local_min)

            sum += nums[i]

        if global_min == sum:
            return global_max

        return max(global_max, sum - global_min)
