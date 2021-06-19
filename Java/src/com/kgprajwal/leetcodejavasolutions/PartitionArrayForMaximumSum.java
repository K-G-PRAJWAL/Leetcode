package com.kgprajwal.leetcodejavasolutions;

public class PartitionArrayForMaximumSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int currMax = 0, max = 0;
            for (int j = 1; j <= k && i - j >= 0; j++) {
                currMax = Math.max(currMax, arr[i - j]);
                max = Math.max(max, dp[i - j] + currMax * j);
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
