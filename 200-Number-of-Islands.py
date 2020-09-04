class Solution:
    def numIslands(self, grid):
        # Solution 1
        if not grid:
            return 0
        m = len(grid)
        n = len(grid[0])
        ans = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    self.dfs(grid, i, j, m, n)
                    ans += 1
        return ans

    def dfs(self, grid, i, j, m, n):
        if i < 0 or j < 0 or i >= m or j >= n or grid[i][j] != '1':
            return
        grid[i][j] = '*'
        self.dfs(grid, i+1, j, m, n)
        self.dfs(grid, i-1, j, m, n)
        self.dfs(grid, i, j+1, m, n)
        self.dfs(grid, i, j-1, m, n)

        # Solution 2 (visited matrix)
        if not grid:
            return 0
        m = len(grid)
        n = len(grid[0])
        ans = 0
        visited = [[False for i in range(n)] for j in range(m)]
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1' and not visited[i][j]:
                    self.dfs(grid, i, j, m, n, visited)
                    ans += 1
        return ans

    def dfs(self, grid, i, j, m, n, visited):
        if i < 0 or j < 0 or i >= m or j >= n or grid[i][j] != '1' or visited[i][j]:
            return
        visited[i][j] = True
        self.dfs(grid, i+1, j, m, n, visited)
        self.dfs(grid, i-1, j, m, n, visited)
        self.dfs(grid, i, j+1, m, n, visited)
        self.dfs(grid, i, j-1, m, n, visited)


s = Solution()
print(s.numIslands(
    [
        ["1", "1", "1", "1", "0"],
        ["1", "1", "0", "1", "0"],
        ["1", "1", "0", "0", "0"],
        ["0", "0", "0", "0", "0"]
    ]
))
