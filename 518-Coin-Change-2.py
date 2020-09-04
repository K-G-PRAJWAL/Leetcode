class Solution:
    def change(self, amount, coins):
        # Solution 1 - Recursion(TLE)
        # if amount == 0:
        #     return 1
        # if amount < 0 or len(coins) == 0:
        #     return 0
        # return self.change(amount-coins[-1], coins) + self.change(amount, coins[:-1])

        # Solution 2
        dp = [0 for _ in range(amount + 1)]
        dp[0] = 1
        for coin in coins:
            for j in range(coin, amount + 1):
                dp[j] += dp[j - coin]
        return dp[-1]


s = Solution()
print(s.change(5, [1, 2, 5]))
