class Solution:
    def findMaxFish(self, grid: List[List[int]]) -> int:
        rows, cols = len(grid), len(grid[0])
        max_fish = 0

        visited = [[False]*cols for _ in range(rows)]

        def dfs(grid, visited, r, c):
            if r < 0 or r == rows or c < 0 or c == cols or grid[r][c]==0 or visited[r][c]:
                return 0
            visited[r][c] = True

            return (
                grid[r][c]
                +dfs(grid, visited, r, c+1)
                +dfs(grid, visited, r, c-1)
                +dfs(grid, visited, r+1, c)
                +dfs(grid, visited, r-1, c)
            )

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] > 0 and not visited[r][c]:
                    max_fish = max(max_fish, dfs(grid, visited, r, c))

        return max_fish