class Solution:
    def maxAscendingSum(self, nums: List[int]) -> int:
        max_sum = 0

        for start_idx in range(len(nums)):
            current_subarray_sum = nums[start_idx]

            end_idx = start_idx + 1
            while end_idx < len(nums) and nums[end_idx] > nums[end_idx - 1]:
                current_subarray_sum += nums[end_idx]
                end_idx += 1

            max_sum = max(max_sum, current_subarray_sum)

        return max_sum