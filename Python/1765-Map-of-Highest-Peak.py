class Solution:
    def highestPeak(self, isWater: List[List[int]]) -> List[List[int]]:
        rows, cols = len(isWater), len(isWater[0])

        q = deque()
        visited = set()
        ans = [[0]*cols for _ in range(rows)]

        for r in range(rows):
            for c in range(cols):
                if isWater[r][c] == 1:
                    q.append((r, c))
                    visited.add((r, c))
                    ans[r][c] = 0

        while q:
            r, c = q.popleft()
            h = ans[r][c]

            neighbors = [[r+1, c], [r, c+1], [r-1, c], [r, c-1]]
            for nr, nc in neighbors:
                if (
                    nr < 0 or nc < 0 or
                    nr == rows or nc == cols or
                    (nr, nc) in visited):
                    continue
                q.append((nr, nc))
                visited.add((nr, nc))
                ans[nr][nc] = h+1

        return ans