class Solution:
    def minPathSum(self, grid):
        # Three-Pass
        r = len(grid)
        c = len(grid[0])
        for i in range(1, c):
            grid[0][i] += grid[0][i-1]
        for i in range(1, r):
            grid[i][0] += grid[i-1][0]
        for i in range(1, r):
            for j in range(1, c):
                grid[i][j] += min(grid[i-1][j], grid[i][j-1])
        return grid[-1][-1]
        

        # One-Pass
        r = len(grid)
        c = len(grid[0])
        for i in range(r):
            for j in range(c):
                if i==0 and j==0:
                    continue
                elif i==0:
                    grid[i][j] += grid[i][j-1]
                elif j==0:
                    grid[i][j] += grid[i-1][j]
                else:
                    grid[i][j] += min(grid[i-1][j], grid[i][j-1])
        return grid[-1][-1]


        # Dijkstra
        import heapq
        r = len(grid)
        c = len(grid[0])
        heap = [(grid[0][0], (0, 0))]
        visited = set()
        while heap:
            val, (i, j) = heapq.heappop(heap)
            if (i, j) in visited:
                continue
            visited.add((i,j))
            for x, y in ((i+1, j), (i, j+1)):
                if x<r and y<c:
                    newVal = val+grid[x][y]
                    heapq.heappush(heap, (newVal, (x, y)))
                    if x==r-1 and y==c-1:
                        return newVal
        return val


s = Solution()
print(s.minPathSum(
    [
  [1,3,1],
  [1,5,1],
  [4,2,1]
    ]
))