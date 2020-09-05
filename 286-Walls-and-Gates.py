class Solution:
    def wallsAndGates(self, rooms):
        m = len(rooms)
        n = len(rooms[0])
        for i in range(m):
            for j in range(n):
                if rooms[i][j] == 0:
                    self.dfs(i, j, 0, rooms, m, n)
        return rooms

    def dfs(self, i, j, dist, rooms, m, n):
        if i < 0 or i >= m or j < 0 or j >= n or rooms[i][j] < dist:
            return
        rooms[i][j] = dist
        self.dfs(i+1, j, dist+1, rooms, m, n)
        self.dfs(i-1, j, dist+1, rooms, m, n)
        self.dfs(i, j+1, dist+1, rooms, m, n)
        self.dfs(i, j-1, dist+1, rooms, m, n)


s = Solution()
print(s.wallsAndGates(
    [
      [2147483647, -1, 0, 2147483647],
      [2147483647, 2147483647, 2147483647, -1],
      [2147483647, -1, 2147483647, -1],
      [0, -1, 2147483647, 2147483647]
      ]
))
