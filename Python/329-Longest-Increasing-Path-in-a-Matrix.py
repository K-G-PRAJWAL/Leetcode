class Solution:
    def longestIncreasingPath(self, matrix):
        def dfs(i, j):  
            if not dp[i][j]:
                val = matrix[i][j]
                dp[i][j] = 1+max(
                    dfs(i-1, j) if i and val<matrix[i-1][j] else 0,
                    dfs(i+1, j) if i<r-1 and val<matrix[i+1][j] else 0,
                    dfs(i, j-1) if j and val<matrix[i][j-1] else 0,
                    dfs(i, j+1) if j<c-1 and val<matrix[i][j+1] else 0
                )
            return dp[i][j]
        if not matrix:
            return 0
        r = len(matrix)
        c = len(matrix[0])
        dp = [[0]*c for _ in range(r)]
        return max(dfs(i, j) for i in range(r) for j in range(c))
        
    
s = Solution()
print(s.longestIncreasingPath(
    [
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
))