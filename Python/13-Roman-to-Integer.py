class Solution:
    def romanToInt(self, s: str) -> int:
        d = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
        p, c, t = 0, 0, 0
        for i in range(len(s)):
            c = d[s[i]]
            if c > p:
                t += c-2*p
            else:
                t += c
            p = c
        return t


s = Solution()
print(s.romanToInt('IX'))
