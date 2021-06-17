package com.kgprajwal.leetcodejavasolutions;

public class MatrixBlockColumn {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) return mat;
        int[][] dp = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[0].length; j++)
                dp[i][j] = helper(mat, i, j, k);
        return dp;
    }

    int helper(int[][] mat, int r, int c, int k) {
        int ans = 0;
        for (int i = Math.max(0, r - k); i <= Math.min(mat.length - 1, r + k); i++)
            for (int j = Math.max(0, c - k); j <= Math.min(mat[0].length - 1, c + k); j++)
                ans += mat[i][j];
        return ans;
    }
}
