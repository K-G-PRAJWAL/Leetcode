class Solution:
    def zigzagTraversal(self, grid: List[List[int]]) -> List[int]:
        m = len(grid)
        n = len(grid[0])

        ans = []
        switch = True
        for i in range(m):
            if i %2 == 0:
                switch = False
            else:
                switch = True
            tmp = []
            for j in range(n):
                if j % 2 ==0 and switch is False:
                    tmp.append(grid[i][j])

                elif j%2 == 1 and switch is True:
                    tmp.append(grid[i][j])
            if switch is False:
                ans.extend(tmp)
            else:
                ans.extend(tmp[::-1])
        return ans

    def zigzagTraversal_2(self, grid: List[List[int]]) -> List[int]:
        ans = []
        f = 1
        for row in grid:
            if f:
                ans.extend(row)
            ans.extend(row[::-1])
        return ans[::2]