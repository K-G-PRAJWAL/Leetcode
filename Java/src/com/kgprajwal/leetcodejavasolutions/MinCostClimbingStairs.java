package com.kgprajwal.leetcodejavasolutions;

public class MinCostClimbingStairs {
    /* Recursion
    private int helper(int[] cost, int step) {
        if (step < 0) return 0;
        if (step == 0 || step == 1) return cost[step];
        return cost[step] + Math.min(helper(cost, step - 1), helper(cost, step - 2));
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        return Math.min(helper(cost, n - 1), helper(cost, n - 2));
    } */


    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < 2) dp[i] = cost[i];
            else dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}
