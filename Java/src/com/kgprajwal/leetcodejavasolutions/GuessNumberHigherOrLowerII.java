package com.kgprajwal.leetcodejavasolutions;

public class GuessNumberHigherOrLowerII {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 2][n + 2];
        for (int x = 1; x < n; x++) {
            for (int i = 1; i <= n - x; i++) {
                int j = i + x;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++)
                    dp[i][j] = Math.min(dp[i][j], k + Math.max(dp[i][k - 1], dp[k + 1][j]));
            }
        }
        return dp[1][n];
    }
}
