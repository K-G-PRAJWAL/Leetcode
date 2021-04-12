package com.kgprajwal.leetcodejavasolutions;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < dp.length; i++) {
            int val = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) val = Math.max(val, dp[j]);
            }
            dp[i] = val + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
