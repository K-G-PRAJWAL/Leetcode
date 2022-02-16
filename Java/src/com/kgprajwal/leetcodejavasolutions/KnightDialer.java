package com.kgprajwal.leetcodejavasolutions;

public class KnightDialer {
    int mod = (int) Math.pow(10, 9) + 7;

    private long helper(long[][][] dp, int i, int j, int n) {
        if (i < 0 || j < 0 || i >= 4 || j >= 3 || (i == 3 && j != 1)) return 0;
        if (n == 1) return 1;
        if (dp[n][i][j] > 0) return dp[n][i][j];
        dp[n][i][j] = helper(dp, i - 1, j - 2, n - 1) % mod
                    + helper(dp, i - 2, j - 1, n - 1) % mod
                    + helper(dp, i - 2, j + 1, n - 1) % mod
                    + helper(dp, i - 1, j + 2, n - 1) % mod
                    + helper(dp, i + 1, j + 2, n - 1) % mod
                    + helper(dp, i + 2, j + 1, n - 1) % mod
                    + helper(dp, i + 2, j - 1, n - 1) % mod
                    + helper(dp, i + 1, j - 2, n - 1) % mod;
        return dp[n][i][j];
    }

    public int knightDialer(int n) {
        long[][][] dp = new long[n + 1][4][3];
        long ans = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                ans = (ans + helper(dp, i, j, n)) % mod;
            }
        }
        return (int) ans;
    }
}
