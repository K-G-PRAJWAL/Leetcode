package com.kgprajwal.leetcodejavasolutions;

public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        int prevDiff = nums[1] - nums[0];
        int cnt = prevDiff != 0 ? 2 : 1;
        for (int i = 2; i < nums.length; i++) {
            int currDiff = nums[i] - nums[i - 1];
            if ((currDiff > 0 && prevDiff <= 0) || (currDiff < 0 && prevDiff >= 0)) {
                cnt++;
                prevDiff = currDiff;
            }
        }
        return cnt;
    }
}
