class Solution:
    def diagonalSum(self, mat):
        n = len(mat)
        flag = False
        if n % 2 == 0:
            flag = True
        ans = 0
        if n % 2 == 0:
            flag = True
        for i in range(n):
            for j in range(n):
                # Matrix length is odd
                if not flag:
                    if i == j and not i == n//2 and not j == n//2:
                        ans += mat[i][j]
                    elif i+j == n-1:
                        ans += mat[i][j]
                else:
                    # Matrix length is even
                    if i == j:
                        ans += mat[i][j]
                    elif i+j == n-1:
                        ans += mat[i][j]
        return ans


s = Solution()
print(s.diagonalSum(
    [[1, 2, 3],
     [4, 5, 6],
     [7, 8, 9]]
))
print(s.diagonalSum(
    [[1, 1, 1, 1],
     [1, 1, 1, 1],
     [1, 1, 1, 1],
     [1, 1, 1, 1]]
))
