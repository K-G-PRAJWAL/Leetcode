package com.kgprajwal.leetcodejavasolutions;

public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        int max = 1, cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) cnt++;
            else cnt = 1;
            max = Math.max(max, cnt);
        }
        return max;
    }
}
