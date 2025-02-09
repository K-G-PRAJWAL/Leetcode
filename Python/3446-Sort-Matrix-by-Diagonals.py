class Solution:
    def sortMatrix(self, grid: List[List[int]]) -> List[List[int]]:
        n = len(grid)

        for d in range(n):
            diagonal = []
            i, j = d, 0
            while i < n and j < n:
                diagonal.append(grid[i][j])
                i += 1
                j += 1
            diagonal.sort(reverse=True)
            i, j = d, 0
            idx = 0
            while i < n and j < n:
                grid[i][j] = diagonal[idx]
                i += 1
                j += 1
                idx += 1

        for d in range(1, n):
            diagonal = []
            i, j = 0, d
            while i < n and j < n:
                diagonal.append(grid[i][j])
                i += 1
                j += 1
            diagonal.sort()
            i, j = 0, d
            idx = 0
            while i < n and j < n:
                grid[i][j] = diagonal[idx]
                i += 1
                j += 1
                idx += 1

        return grid