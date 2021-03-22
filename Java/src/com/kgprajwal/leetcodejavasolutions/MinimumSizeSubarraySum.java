package com.kgprajwal.leetcodejavasolutions;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int l = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= target) {
                ans = Math.min(ans, i + 1 - l);
                sum -= nums[l++];
            }
        }
        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }
}
