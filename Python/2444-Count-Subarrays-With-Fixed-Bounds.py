class Solution:
    def countSubarrays(self, nums: List[int], minK: int, maxK: int) -> int:
        n = len(nums)

        left_bound = -1
        last_min = last_max = -1

        cnt = 0

        for i in range(n):
            if nums[i] >= minK and nums[i] <= maxK:
                last_min = i if nums[i] == minK else last_min
                last_max = i if nums[i] == maxK else last_max
                cnt += max(0, min(last_min, last_max) - left_bound)
            else:
                left_bound = i
                last_min = -1
                last_max = -1

        return cnt
