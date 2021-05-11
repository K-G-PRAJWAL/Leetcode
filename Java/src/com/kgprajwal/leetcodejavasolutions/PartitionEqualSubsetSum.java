package com.kgprajwal.leetcodejavasolutions;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        int sum = 0;
        for (int i : nums) sum += i;
        if (sum % 2 != 0) return false;
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j >= nums[i]; j--) dp[j] = dp[j] || dp[j - nums[i]];
        }
        return dp[sum];
    }
}
