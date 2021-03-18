package com.kgprajwal.leetcodejavasolutions;

public class NumberOfIslands {
    int n, m;

    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        if (n == 0) return 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1') {
                    helper(grid, i, j);
                    ++count;
                }
        }
        return count;
    }

    private void helper(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
        grid[i][j] = '0';
        helper(grid, i + 1, j);
        helper(grid, i - 1, j);
        helper(grid, i, j + 1);
        helper(grid, i, j - 1);
    }
}
