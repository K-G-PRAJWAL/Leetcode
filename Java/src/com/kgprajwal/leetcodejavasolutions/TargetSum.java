package com.kgprajwal.leetcodejavasolutions;

import java.util.Arrays;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int[][] dp = new int[nums.length][2001];
        for (int[] i : dp) Arrays.fill(i, Integer.MIN_VALUE);
        return helper(nums, 0, 0, target, dp);
    }

    int helper(int[] nums, int i, int currSum, int target, int[][] dp) {
        if (i == nums.length) {
            if (currSum == target) return 1;
            else return 0;
        } else {
            if (dp[i][currSum + 1000] != Integer.MIN_VALUE) return dp[i][currSum + 1000];
            int add = helper(nums, i + 1, currSum + nums[i], target, dp);
            int subtract = helper(nums, i + 1, currSum - nums[i], target, dp);
            dp[i][currSum + 1000] = add + subtract;
            return dp[i][currSum + 1000];
        }
    }
}
