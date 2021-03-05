package com.kgprajwal.leetcodejavasolutions;

import java.util.Arrays;

public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int[] a : dp) Arrays.fill(a, Integer.MAX_VALUE);
        dp[m][n - 1] = 1;
        dp[m - 1][n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int x = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = x <= 0 ? 1 : x;
            }
        }
        return dp[0][0];
    }
}
