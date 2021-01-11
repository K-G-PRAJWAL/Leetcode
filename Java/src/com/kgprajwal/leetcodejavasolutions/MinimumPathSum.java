package com.kgprajwal.leetcodejavasolutions;

public class MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (row == 0 && col == 0) grid[row][col] = grid[row][col];
                else if (row == 0 && col != 0) grid[row][col] = grid[row][col] + grid[row][col - 1];
                else if (col == 0 && row != 0) grid[row][col] = grid[row][col] + grid[row-1][col];
                else grid[row][col] = grid[row][col] + Math.min(grid[row - 1][col], grid[row][col - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        }));
    }
}
