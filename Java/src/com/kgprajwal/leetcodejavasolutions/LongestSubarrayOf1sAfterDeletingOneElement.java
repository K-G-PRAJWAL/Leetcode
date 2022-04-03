package com.kgprajwal.leetcodejavasolutions;

public class LongestSubarrayOf1sAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int currCnt = 0, prevCnt = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) currCnt++;
            else {
                ans = Math.max(ans, currCnt + prevCnt);
                prevCnt = currCnt;
                currCnt = 0;
            }
        }
        ans = Math.max(ans, currCnt + prevCnt);
        return ans == nums.length ? ans - 1 : ans;
    }
}
