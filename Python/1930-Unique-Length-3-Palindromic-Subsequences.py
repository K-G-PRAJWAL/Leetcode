class Solution:
    def countPalindromicSubsequence(self, s: str) -> int:
        n = len(s)

        chars = set(s)
        ans = 0

        for ch in chars:
            i, j = s.index(ch), s.rindex(ch)

            middle = set()
            for k in range(i+1, j):
                middle.add(s[k])

            ans += len(middle)

        return ans