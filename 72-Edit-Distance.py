class Solution:
    def minDistance(self, word1, word2):

        # Recursion

        # if not word1 and not word2:
        #     return 0
        # if not word1:
        #     return len(word2)
        # if not word2:
        #     return len(word1)
        # if word1[0]==word2[0]:
        #     return self.minDistance(word1[1:], word2[1:])
        # op1 = 1+self.minDistance(word1, word2[1:])
        # op2 = 1+self.minDistance(word1[1:], word2)
        # op3 = 1+self.minDistance(word1[1:], word2[1:])
        # return min(op1, op2, op3)

        # Memoization

        # if not word1 and not word2:
        #     return 0
        # if not len(word1) or not len(word2):
        #     return len(word1) or len(word2)
        # if word1[0]==word2[0]:
        #     return self.minDistance(word1[1:], word2[1:])
        # if (word1, word2) not in cache:
        #     insertOp1 = 1+self.minDistance(word1, word2[1:])
        #     deleteOp2 = 1+self.minDistance(word1[1:], word2)
        #     replaceOp3 = 1+self.minDistance(word1[1:], word2[1:])
        #     cache[(word1, word2)] = min(insertOp1, deleteOp2, replaceOp3)
        # return cache[(word1, word2)]

        # DP

        # m = len(word1)
        # n = len(word2)
        # dp = [[0]*(n+1) for i in range(m+1)]
        # for i in range(m+1):
        #     dp[i][0] = i
        # for j in range(n+1):
        #     dp[0][j] = j
        # for i in range(1, m+1):
        #     for j in range(1, n+1):
        #         if word1[i-1]==word2[j-1]:
        #             dp[i][j] = dp[i-1][j-1]
        #         else:
        #             dp[i][j] = 1+min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])
        # return dp[-1][-1]

        # Most Efficient - Time 96.38% | Space 82.34%
        cache = {}

        def solve(word1, word2, i, j):
            if (i, j) in cache:
                return cache[(i, j)]
            if i == len(word1) and j == len(word2):
                return 0
            if i == len(word1):
                return len(word2)-j
            if j == len(word2):
                return len(word1)-i
            if word1[i] == word2[j]:
                cnt = solve(word1, word2, i+1, j+1)
            else:
                op1 = solve(word1, word2, i, j+1)
                op2 = solve(word1, word2, i+1, j)
                op3 = solve(word1, word2, i+1, j+1)
                cnt = 1+min(op1, op2, op3)
            cache[(i, j)] = cnt
            return cnt
        return solve(word1, word2, 0, 0)


s = Solution()
print(s.minDistance('horse', 'ros'))
print(s.minDistance('intention', 'execution'))
