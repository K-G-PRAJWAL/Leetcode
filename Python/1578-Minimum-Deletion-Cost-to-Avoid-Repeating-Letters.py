class Solution:
    def minCost(self, s, cost):
        ans = 0
        prev = 0
        n = len(s)
        for i in range(1, n):
            if s[prev] != s[i]:
                prev = i
            else:
                ans += min(cost[prev], cost[i])
                if cost[prev] < cost[i]:
                    prev = i
        return ans


s = Solution()
print(s.minCost("abaac", [1, 2, 3, 4, 5]))
