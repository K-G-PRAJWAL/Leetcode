class Solution:
    def minChangeTP(self, n, coins, length, dp):
        if n == 0:
            return 0
        if dp[n] != 0:
            return dp[n]
        ans = 999999
        for i in range(length):
            if n-coins[i] >= 0:
                sub = self.minChangeTP(n-coins[i], coins, length, dp)
                ans = min(ans, sub+1)
        dp[n] = ans
        return dp[n]

    def minChangeBU(self, n, coins, length, dp):
        if n == 0:
            return 0
        for i in range(1, n+1):
            dp[i] = 999999
            for j in range(length):
                if i-coins[j] >= 0:
                    sub = dp[i-coins[j]]
                    dp[i] = min(dp[i], sub+1)
        return dp[n]

    def coinChange(self, coins, amount):
        dp = [0 for i in range(10000)]
        result = self.minChangeBU(amount, coins, len(coins), dp)
        if result == 999999:
            return -1
        return result


s = Solution()
print(s.coinChange([186, 419, 83, 408], 6249))
