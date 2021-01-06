package com.kgprajwal.leetcodejavasolutions;

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i=1;i<n;i++) {
            dp[i] = nums[i] + (dp[i-1]>0 ? dp[i-1] : 0);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // Alternative
//    public static int maxSubArray(int[] nums) {
//        int n = nums.length;
//        int maxTillNow = nums[0];
//        int maxEnding = nums[0];
//        for(int i=1;i<n;i++) {
//            maxEnding = Math.max(nums[i], maxEnding+nums[i]);
//            maxTillNow = Math.max(maxEnding, maxTillNow);
//        }
//        return maxTillNow;
//    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
