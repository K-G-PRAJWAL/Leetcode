# Kadane's Algorithm Solution
class Solution:
    def maxProfit(self, prices):
        if len(prices) < 2:
            return 0
        globalMaxima = 0
        localMaxima = prices[0]
        for i in range(1, len(prices)):
            localMaxima = min(localMaxima, prices[i])
            globalMaxima = max(globalMaxima, prices[i]-localMaxima)
        return globalMaxima


s = Solution()
print(s.maxProfit([7, 1, 5, 3, 6, 4]))
