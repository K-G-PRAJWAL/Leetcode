class Solution:
    def findJudge(self, n, trust) -> int:
        trust_graph = [0 for _ in range(n+1)]
        for truster, trusted in trust:
            trust_graph[truster] -= 1
            trust_graph[trusted] += 1
        for i in range(1, n+1):
            if trust_graph[i] == n-1:
                return i
        return -1


s = Solution()
print(s.findJudge(2, [[1, 2]]))
