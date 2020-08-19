class Solution:

    # Solution 1
    def isValidSudoku(self, board):
        return self.checkRow(board) and self.checkCol(board) and self.checkBox(board)

    def checkRow(self, board):
        for row in board:
            if not self.check(row):
                return False
        return True

    def checkCol(self, board):
        for col in zip(*board):
            if not self.check(col):
                return False
        return True

    def checkBox(self, board):
        for i in (0, 3, 6):
            for j in (0, 3, 6):
                box = [board[x][y]
                       for x in range(i, i+3) for y in range(j, j+3)]
                if not self.check(box):
                    return False
        return True

    def check(self, num):
        ans = [i for i in num if i != '.']
        return len(ans) == len(set(ans))

    # Solution 2
    def isValidSudoku(self, board):
        ans = set()
        for i in range(0, 9):
            for j in range(0, 9):
                if board[i][j] != '.':
                    curr = board[i][j]
                    if (i, curr) in ans or (curr, j) in ans or (i//3, j//3, curr) in ans:
                        return False
                    ans.add((i, curr))
                    ans.add((curr, j))
                    ans.add((i//3, j//3, curr))
        return True


s = Solution()
print(s.isValidSudoku([
    ["5", "3", ".", ".", "7", ".", ".", ".", "."],
    ["6", ".", ".", "1", "9", "5", ".", ".", "."],
    [".", "9", "8", ".", ".", ".", ".", "6", "."],
    ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
    ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
    ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
    [".", "6", ".", ".", ".", ".", "2", "8", "."],
    [".", ".", ".", "4", "1", "9", ".", ".", "5"],
    [".", ".", ".", ".", "8", ".", ".", "7", "9"]
]))
