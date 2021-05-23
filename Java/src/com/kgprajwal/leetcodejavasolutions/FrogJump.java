package com.kgprajwal.leetcodejavasolutions;

public class FrogJump {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n + 1];
        dp[0][1] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = stones[i] - stones[j];
                if (diff < 0 || diff > n || !dp[j][diff]) continue;
                dp[i][diff] = true;
                if (diff - 1 >= 0) dp[i][diff - 1] = true;
                if (diff + 1 <= n) dp[i][diff + 1] = true;
                if (i == n - 1) return true;
            }
        }
        return false;
    }
}
