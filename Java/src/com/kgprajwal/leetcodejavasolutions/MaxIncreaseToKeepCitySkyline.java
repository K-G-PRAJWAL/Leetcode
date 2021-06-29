package com.kgprajwal.leetcodejavasolutions;

public class MaxIncreaseToKeepCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] rMax = new int[n];
        int[] cMax = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rMax[i] = Math.max(rMax[i], grid[i][j]);
                cMax[j] = Math.max(cMax[j], grid[i][j]);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                ans += Math.min(rMax[i], cMax[j]) - grid[i][j];
        return ans;
    }
}
