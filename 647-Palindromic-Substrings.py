class Solution:
    c = 0

    def countSubstrings(self, s):
        # Solution 1: DP
        n = len(s)
        dp = [[False for i in range(n)] for j in range(n)]
        count = 0
        for i in range(n):
            dp[i][i] = True
            count += 1
        for i in range(n-1):
            if s[i] == s[i+1]:
                dp[i][i+1] = True
                count += 1
        for k in range(3, n+1):
            for i in range(n-k+1):
                j = i+k-1
                if dp[i+1][j-1] == True and s[i] == s[j]:
                    dp[i][j] = True
                    count += 1
        return count

        # Solution 2: Expand
        self.c = 0
        n = len(s)
        for i in range(n):
            self.check(s, i, i)
            self.check(s, i, i+1)
        return self.c

    def check(self, s, l, r):
        n = len(s)
        while l >= 0 and r < n and s[l] == s[r]:
            self.c += 1
            l -= 1
            r += 1


s = Solution()
print(s.countSubstrings('aaa'))
