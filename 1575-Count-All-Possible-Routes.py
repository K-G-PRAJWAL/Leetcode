class Solution:
    def countRoutes(self, locations, start, finish, fuel):
        n = len(locations)
        dp = [[-1 for i in range(fuel+1)] for j in range(n)]
        return self.solve(n, locations, start, finish, dp, fuel)

    def solve(self, n, locations, curr, end, dp, fuel):
        if fuel < 0:
            return 0
        if dp[curr][fuel] != -1:
            return dp[curr][fuel]
        if curr == end:
            ans = 1
        else:
            ans = 0
        for next in range(n):
            if next != curr:
                ans = (ans+self.solve(n, locations, next, end, dp, fuel -
                                      abs(locations[curr]-locations[next]))) % (10**9+7)
        dp[curr][fuel] = ans
        print(dp)
        return dp[curr][fuel]


s = Solution()
print(s.countRoutes([2, 3, 6, 8, 4], 1, 3, 5))
