class Solution:
    def maxAbsoluteSum(self, nums: List[int]) -> int:
        min_pref = 0
        max_pref = 0
        curr = 0
        ans = 0

        for n in nums:
            curr += n

            ans = max(ans, abs(curr - min_pref), abs(curr - max_pref))
            max_pref = max(max_pref, curr)
            min_pref = min(min_pref, curr)

        return ans