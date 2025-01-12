class Solution:
    def helper(self, i, j, k, r, c, coins, dp):
        # Boundary check
        if i >= r or j >= c:
            return -float("inf")

        # Base case -> upon reaching bottom-right corner
        if i == r-1 and j == c-1:
            if coins[i][j] < 0:
                return 0 if k > 0 else coins[i][j]
            else:
                return coins[i][j]

        # If result is memoized
        if dp[i][j][k] != -float("inf"):
            return dp[i][j][k]

        right = -float("inf")
        down = -float("inf")

        # Compute the max
        if coins[i][j] < 0:
            if k > 0:
                right = self.helper(i, j+1, k-1, r, c, coins, dp)
                down = self.helper(i+1, j, k-1, r, c, coins, dp)

        right = max(right, coins[i][j]+self.helper(i, j+1, k, r, c, coins, dp))
        down = max(down, coins[i][j]+self.helper(i+1, j, k, r, c, coins, dp))

        dp[i][j][k] = max(right, down)
        return dp[i][j][k]


    def maximumAmount(self, coins: List[List[int]]) -> int:
        r = len(coins)
        c = len(coins[0])

        # dp(i, j, k) -> i+j=cell,  k=neutralized robbers
        # Base case: dp(i-1, j-1, 0) = coins[n-1][m-1]
        # dp(n-1, m-1, 1) = max(0, coins[n-1][m-1])
        # dp(n-1, m-1, 2) = max(0, coins[n-1][m-1])

        # Transitions:
        # not neutralise => dp(i, j, k) = coins(i, j) + max(dp(i+1, j, k), dp(i, j+1, k))
        # neutralize => dp(i, j, k) = max(0, coins(i, j)) + max(dp(i+1, j, k-1), dp(i, j+1, k-1))

        dp = [[[-float('inf')]*3 for _ in range(c)] for _ in range(r)]

        return self.helper(0, 0, 2, r, c, coins, dp)