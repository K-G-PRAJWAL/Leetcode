class Solution:
    def minFlipsMonoIncr(self, s: str) -> int:
        ans = 0
        cnt_ones = 0

        for ch in s:
            if ch == '1':
                cnt_ones += 1
            else:
                ans = min(ans + 1, cnt_ones)

        return ans
