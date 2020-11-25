from collections import deque


class Solution:
    def minDays(self, n):
        # DP Solution
        self.dp = {}
        self.dp[0], self.dp[1] = 0, 1
        ans = self.solve(n)
        return ans

    def solve(self, n):
        if n in self.dp:
            return self.dp[n]
        self.dp[n] = 1+min(n % 2+self.solve(n//2), n % 3+self.solve(n//3))
        return self.dp[n]

        # BFS Solution
        q = deque()
        q.append(n)
        cnt = 0
        visited = set()
        while len(q):
            qLen = len(q)
            cnt += 1
            for i in range(qLen):
                curr = q.popleft()
                if curr % 3 == 0 and curr//3 not in visited:
                    q.append(curr//3)
                    visited.add(curr//3)
                if curr % 2 == 0 and curr//2 not in visited:
                    q.append(curr//2)
                    visited.add(curr//2)
                if curr-1 not in visited:
                    q.append(curr-1)
                    visited.add(curr - 1)
                if curr-1 == 0:
                    return cnt


s = Solution()
print(s.minDays(6))
print(s.minDays(10))
print(s.minDays(56))
