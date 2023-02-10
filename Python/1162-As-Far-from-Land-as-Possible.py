class Solution:
    def maxDistance(self, grid: List[List[int]]) -> int:
        n = len(grid)
        q = deque()
        ans = -1

        for r in range(n):
            for c in range(n):
                if grid[r][c] == 1:
                    q.append([r, c])

        dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        while q:
            r, c = q.popleft()
            ans = grid[r][c]

            for d_r, d_c in dirs:
                new_r, new_c = r + d_r, c+d_c
                if min(new_r, new_c) >= 0 and max(new_r, new_c) < n and grid[new_r][new_c] == 0:
                    q.append([new_r, new_c])
                    grid[new_r][new_c] = grid[r][c]+1

        return ans - 1 if ans > 1 else -1
