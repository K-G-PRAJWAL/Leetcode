package com.kgprajwal.leetcodejavasolutions;

public class LongestIncreasingPathInAMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int r = matrix.length;
        int c = matrix[0].length;
        int longestPath = 0;
        int[][] dp = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int path = dfs(matrix, i, j, r, c, dp, -1);
                longestPath = Math.max(longestPath, path);
            }
        }
        return longestPath;
    }

    int dfs(int[][] matrix, int i, int j, int r, int c, int[][] dp, int currVal) {
        int longestPath = 0;
        if (i < 0 || i >= r || j < 0 || j >= c || matrix[i][j] <= currVal) return 0;
        if (dp[i][j] != 0) return dp[i][j];
        longestPath = Math.max(longestPath, dfs(matrix, i + 1, j, r, c, dp, matrix[i][j]));
        longestPath = Math.max(longestPath, dfs(matrix, i - 1, j, r, c, dp, matrix[i][j]));
        longestPath = Math.max(longestPath, dfs(matrix, i, j + 1, r, c, dp, matrix[i][j]));
        longestPath = Math.max(longestPath, dfs(matrix, i, j - 1, r, c, dp, matrix[i][j]));
        longestPath++;
        dp[i][j] = longestPath;
        return longestPath;
    }
}
