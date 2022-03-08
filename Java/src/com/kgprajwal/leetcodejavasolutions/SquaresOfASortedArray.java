package com.kgprajwal.leetcodejavasolutions;

public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int l = 0, r = n - 1;
        int idx = n - 1;
        while (l <= r) {
            if (nums[l] * nums[l] > nums[r] * nums[r]) {
                ans[idx] = nums[l] * nums[l];
                l++;
            } else {
                ans[idx] = nums[r] * nums[r];
                r--;
            }
            idx--;
        }
        return ans;
    }
}
