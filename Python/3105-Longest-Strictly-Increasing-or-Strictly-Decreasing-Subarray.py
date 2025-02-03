class Solution:
    def longestMonotonicSubarray(self, nums: List[int]) -> int:
        n = len(nums)
        s_inc, s_dec = 0, 0
        inc_max = 0
        dec_max = 0

        while n >= 2:
            if nums[n-1] > nums[n-2]:
                s_inc += 1
                inc_max = max(inc_max, s_inc)
            else:
                s_inc = 0
            if nums[n-1] < nums[n-2]:
                s_dec += 1
                dec_max = max(dec_max, s_dec)
            else:
                s_dec = 0

            n-=1

        return max(inc_max, dec_max)+1