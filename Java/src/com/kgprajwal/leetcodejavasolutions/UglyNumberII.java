package com.kgprajwal.leetcodejavasolutions;

public class UglyNumberII {
    public int nthUglyNumber(int n) {
        int i = 0, j = 0, k = 0;
        int p = 1;
        int[] dp = new int[n];
        dp[0] = 1;
        while (p < n) {
            dp[p] = Math.min(dp[i] * 2, Math.min(dp[j] * 3, dp[k] * 5));
            if (dp[p] == dp[i] * 2) i++;
            if (dp[p] == dp[j] * 3) j++;
            if (dp[p] == dp[k] * 5) k++;
            p++;
        }
        return dp[n - 1];
    }
}
