class Solution:
    def maxScore(self, s: str) -> int:
        n = len(s)
        maxi = -1

        for i in range(n-1):
            l, r = s[:i+1], s[i+1:]
            curr_sum = l.count('0')+r.count('1')
            maxi = max(maxi, curr_sum)

        return maxi
