package com.kgprajwal.leetcodejavasolutions;

public class CherryPickupII {
//    static int backtrack(int r, int r1, int r2, int[][] grid, int[][][] dp) {
//        if (r1 < 0 || r1 >= grid[0].length || r2 < 0 || r2 >= grid[0].length) return 0;
//        if (dp[r][r1][r2] != -1) return dp[r][r1][r2];
//        int ans = 0;
//        ans += grid[r][r1];
//        if (r1 != r2) ans += grid[r][r2];
//        if (r != grid.length - 1) {
//            int maxCherries = 0;
//            for (int newCol1 = r1 - 1; newCol1 <= r1 + 1; newCol1++) {
//                for (int newCol2 = r2 - 1; newCol2 <= r2 + 1; newCol2++) {
//                    maxCherries = Math.max(maxCherries, backtrack(r + 1, newCol1, newCol2, grid, dp));
//                }
//            }
//            ans += maxCherries;
//        }
//        dp[r][r1][r2] = ans;
//        return ans;
//    }
//
//    public int cherryPickup(int[][] grid) {
//        int r = grid.length;
//        int c = grid[0].length;
//        int[][][] dp = new int[r][c][c];
//        for (int i = 0; i < r; i++) {
//            for (int j = 0; j < c; j++) {
//                for (int k = 0; k < c; k++) {
//                    dp[i][j][k] = -1;
//                }
//            }
//        }
//        return backtrack(0, 0, c - 1, grid, dp);
//    }

    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        Integer[][][] dp = new Integer[rows][columns][columns];
        return dfs(grid, rows, columns, dp, 0, 0, columns - 1);
    }

    int dfs(int[][] grid, int rows, int columns, Integer[][][] dp, int row, int column1, int column2) {
        int ans = 0;
        if (row == rows) return 0;
        if (dp[row][column1][column2] != null) return dp[row][column1][column2];
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int n_column1 = column1 + i;
                int n_column2 = column2 + j;

                if (n_column1 >= 0 && n_column1 < columns && n_column2 >= 0 && n_column2 < columns) {
                    ans = Math.max(ans, dfs(grid, rows, columns, dp, row + 1, n_column1, n_column2));

                }
            }
        }

        int cherry = column1 == column2 ? grid[row][column1] : grid[row][column1] + grid[row][column2];
        return dp[row][column1][column2] = ans + cherry;
    }
}
