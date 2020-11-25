class Solution:
    def Node(self, val, next=None):
        self.val = val
        self.next = next

    def findSmallestSetOfVertices(self, n: int, edges):
        x = [0 for i in range(n)]
        for u, v in edges:
            x[v] += 1
        return [u for u in range(n) if x[u] == 0]


s = Solution()
print(s.findSmallestSetOfVertices(6, [[0, 1], [0, 2], [2, 5], [3, 4], [4, 2]]))
