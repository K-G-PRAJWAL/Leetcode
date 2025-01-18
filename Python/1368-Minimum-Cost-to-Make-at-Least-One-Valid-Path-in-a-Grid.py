class Solution:
    def minCost(self, grid: List[List[int]]) -> int:
        rows, cols = len(grid), len(grid[0])
        dirs = {
            1: [0, 1],
            2: [0, -1],
            3: [1, 0],
            4: [-1, 0]
        }

        q = deque([(0, 0, 0)])
        min_cost = {(0, 0): 0}

        while q:
            r, c, cost = q.popleft()

            if (r, c) == (rows - 1, cols - 1):
                return cost

            for d in dirs:
                dr, dc = dirs[d]
                nr, nc = r+dr, c+dc
                n_cost = cost if d == grid[r][c] else cost + 1

                if (nr < 0 or nc < 0 or
                    nr == rows or nc == cols or
                    n_cost >= min_cost.get((nr, nc), float("inf"))
                    ):
                    continue

                min_cost[(nr, nc)] = n_cost
                if d == grid[r][c]:
                    q.appendleft((nr, nc, n_cost))
                else:
                    q.append((nr, nc, n_cost))
