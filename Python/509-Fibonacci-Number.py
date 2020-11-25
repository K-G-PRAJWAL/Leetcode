class Solution:
    def fib(self, N):
        # Iterative
        a, b = 0, 1
        for i in range(N):
            a, b = b, a+b
        return a

        # Recursive
        if N == 0:
            return 0
        if N == 1:
            return 1
        return self.fib(N-1)+self.fib(N-2)

        # DP
        if N <= 1:
            return N
        dp = [0 for _ in range(N+1)]
        dp[0] = 0
        dp[1] = 1
        for i in range(2, N+1):
            dp[i] = dp[i-1]+dp[i-2]
        return dp[N]


s = Solution()
print(s.fib(6))
