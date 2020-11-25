class Solution:
    def rotate(self, matrix):
        n = len(matrix)
        matrix.reverse()
        for i in range(n):
            for j in range(i):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
                print(i, j)
        return matrix


s = Solution()
print(s.rotate([
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
]))
