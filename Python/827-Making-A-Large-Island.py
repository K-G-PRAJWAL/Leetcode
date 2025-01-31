class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        n = len(grid)
        dirs = [0, 1, 0, -1, 0]
        next_color = 2
        component_size = defaultdict(int)

        def paint(r, c, color):
            if r < 0 or r == n or c < 0 or c == n or grid[r][c]!=1:
                return
            grid[r][c] = color
            component_size[color] += 1
            for i in range(4):
                paint(r+dirs[i], c+dirs[i+1], color)

        for r in range(n):
            for c in range(n):
                if grid[r][c]!=1:
                    continue
                paint(r, c, next_color)
                next_color += 1

        ans = max(component_size.values() or [0])
        for r in range(n):
            for c in range(n):
                if grid[r][c] != 0:
                    continue
                neighbors = set()
                for i in range(4):
                    nr, nc = r + dirs[i], c + dirs[i+1]
                    if nr < 0 or nr == n or nc < 0 or nc == n or grid[nr][nc] == 0:
                        continue
                    neighbors.add(grid[nr][nc])
                size = 1
                for color in neighbors:
                    size += component_size[color]
                ans = max(ans, size)

        return ans
