package com.kgprajwal.leetcodejavasolutions;

public class ChampagneTower {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[102][102];
        dp[0][0] = (double) poured;
        for (int r = 0; r <= query_row; r++) {
            for (int c = 0; c <= r; c++) {
                double glass = (dp[r][c] - 1.0) / 2.0;
                if (glass > 0) {
                    dp[r + 1][c] += glass;
                    dp[r + 1][c + 1] += glass;
                }
            }
        }
        return Math.min(1, dp[query_row][query_glass]);
    }
}
