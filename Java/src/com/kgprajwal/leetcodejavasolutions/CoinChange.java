package com.kgprajwal.leetcodejavasolutions;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != -1) min = dp[i - coin] < min ? dp[i - coin] : min;
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : 1 + min;
        }
        return dp[amount];
    }
}
