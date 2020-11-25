from collections import deque

class Solution:
    def shortestPath(self, grid, k):
        r = len(grid)
        c = len(grid[0])
        if r==1 and c==1:
            return 0
        q = deque([(0,0,k,0)])
        visited = set([(0,0,k)])
        if k>(r-1)+(c-1):
            return (r-1)+(c-1)
        while q:
            row, col, rem, step = q.popleft()
            for nextRow, nextCol in [(row-1, col), (row, col+1), (row+1, col), (row, col-1)]:
                if nextRow>=0 and nextRow<r and nextCol>=0 and nextCol<c:
                    if grid[nextRow][nextCol]==1 and rem>0 and (nextRow, nextCol, rem-1) not in visited:
                        visited.add((nextRow, nextCol, rem-1))
                        q.append((nextRow, nextCol, rem-1, step+1))
                    if grid[nextRow][nextCol]==0 and (nextRow, nextCol, rem) not in visited:
                        if nextRow==r-1 and nextCol==c-1:
                            return step+1
                        visited.add((nextRow, nextCol, rem))
                        q.append((nextRow, nextCol, rem, step+1))
        return -1


s = Solution()
print(s.shortestPath(
[
    [0,0,0],
    [1,1,0],
    [0,0,0],
    [0,1,1],
    [0,0,0]
], 1
))