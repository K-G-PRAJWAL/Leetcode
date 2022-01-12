package com.kgprajwal.leetcodejavasolutions;

public class CherryPickupII {
    static int backtrack(int r, int r1, int r2, int[][] grid, int[][][] dp) {
        if (r1 < 0 || r1 >= grid[0].length || r2 < 0 || r2 >= grid[0].length) return 0;
        if (dp[r][r1][r2] != -1) return dp[r][r1][r2];
        int ans = 0;
        ans += grid[r][r1];
        if (r1 != r2) ans += grid[r][r2];
        if (r != grid.length - 1) {
            int maxCherries = 0;
            for (int newCol1 = r1 - 1; newCol1 <= r1 + 1; newCol1++) {
                for (int newCol2 = r2 - 1; newCol2 <= r2 + 1; newCol2++) {
                    maxCherries = Math.max(maxCherries, backtrack(r + 1, newCol1, newCol2, grid, dp));
                }
            }
            ans += maxCherries;
        }
        dp[r][r1][r2] = ans;
        return ans;
    }

    public int cherryPickup(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][][] dp = new int[r][c][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < c; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return backtrack(0, 0, c - 1, grid, dp);
    }
}
