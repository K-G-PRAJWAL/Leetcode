class Solution:
    def countServers(self, grid: List[List[int]]) -> int:
        rows = len(grid)
        cols = len(grid[0])
        ans = 0

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 1:
                    can_communicate = False
                    for k in range(cols):
                        if k != c and grid[r][k] == 1:
                            can_communicate = True
                            break
                    if can_communicate:
                        ans += 1
                    else:
                        for k in range(rows):
                            if k != r and grid[k][c] == 1:
                                can_communicate = True
                                break
                        if can_communicate:
                            ans += 1
        return ans

    def countServers_Optimized1(self, grid: List[List[int]]) -> int:
        rows = len(grid)
        cols = len(grid[0])
        ans = 0

        r_counts = [0]*cols
        c_counts = [0]*rows

        for r in range(rows):
            for c in range(cols):
                if grid[r][c]:
                    r_counts[c] += 1
                    c_counts[r] += 1
        for r in range(rows):
            for c in range(cols):
                if grid[r][c]:
                    if r_counts[c] > 1 or c_counts[r] > 1:
                        ans += 1

        return ans

    def countServers_Optimized2(self, grid: List[List[int]]) -> int:
        rows = len(grid)
        cols = len(grid[0])
        ans = 0

        r_counts = [0]*cols
        last_server = [-1]*rows

        for r in range(rows):
            server_cnt = 0
            for c in range(cols):
                if grid[r][c]:
                    server_cnt += 1
                    r_counts[c] += 1
                    last_server[r] = c
            if server_cnt != 1:
                ans += server_cnt
                last_server[r] = -1

        for r in range(rows):
            if last_server[r] != -1 and r_counts[last_server[r]] > 1:
                ans += 1

        return ans