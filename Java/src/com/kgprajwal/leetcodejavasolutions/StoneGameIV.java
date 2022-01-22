package com.kgprajwal.leetcodejavasolutions;

public class StoneGameIV {
    public boolean winnerSquareGame(int n) {
            boolean[] dp = new boolean[n + 1];
            for (int i = 0; i < n + 1; i++) {
                for (int j = 1; j * j <= i; j++) {
                    if (dp[i - (j * j)] == false) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[n];
    }
}
