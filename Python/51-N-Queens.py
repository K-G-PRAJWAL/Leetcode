class Solution:
    # Solution 1
    def solveNQueens(self, n):
        self.ans = []
        self.board = [["." for x in range(n)] for x in range(n)]
        self.n = n
        self.solve(0)
        return self.ans

    def solve(self, col):
        if col == self.n:
            temp = []
            for row in self.board:
                s = ""
                for char in row:
                    s += char
                temp.append(s)
            self.ans.append(temp)
            return

        for row in range(self.n):
            if self.check(row, col):
                self.board[row][col] = "Q"
                self.solve(col+1)
                self.board[row][col] = "."

    def check(self, row, col):
        for currCol in range(col):
            if self.board[row][currCol] == "Q":
                return False
        rowUp = row-1
        rowDown = row+1
        currCol = col-1
        while currCol >= 0:
            if rowUp >= 0:
                if self.board[rowUp][currCol] == "Q":
                    return False
            if rowDown < self.n:
                if self.board[rowDown][currCol] == "Q":
                    return False
            rowUp -= 1
            rowDown += 1
            currCol -= 1
        return True

    #  Solution 2 - Faster+DFS
    def solveNQueens(self, n):
        def dfs(Q, xyDiff, xySum):
            p = len(Q)
            if n == p:
                ans.append(Q)
                return None
            for q in range(n):
                if q not in Q and p - q not in xyDiff and p + q not in xySum:
                    dfs(Q + [q], xyDiff + [p - q], xySum + [p + q])

        ans = []
        dfs([], [], [])
        return [["."*i + "Q" + "."*(n-i-1) for i in sub] for sub in ans]


s = Solution()
print(s.solveNQueens(4))
