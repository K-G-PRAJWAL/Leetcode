class Solution:
    def shortestCommonSupersequence(self, s1: str, s2: str) -> str:
        m, n = len(s1), len(s2)
        dp = [[0] * (n + 1) for _ in range(m + 1)]
        for i, c in reversed(list(enumerate(s1))):
            for j, d in reversed(list(enumerate(s2))):
                dp[i][j] = 1 + dp[i + 1][j + 1] if c == d else max(dp[i + 1][j], dp[i][j + 1])
        i, j, seq = 0, 0, []
        while i < m and j < n:
            if s1[i] == s2[j]:
                seq.append(s1[i])
                i += 1
                j += 1
            elif dp[i + 1][j] > dp[i][j + 1]:
                seq.append(s1[i])
                i += 1
            else:
                seq.append(s2[j])
                j += 1
        return ''.join(seq) + s1[i :] + s2[j :]