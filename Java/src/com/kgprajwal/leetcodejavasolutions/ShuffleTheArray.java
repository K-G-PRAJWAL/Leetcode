package com.kgprajwal.leetcodejavasolutions;

public class ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        for (int i = 0, j = n, k = 0; k < ans.length; i++, j++) {
            ans[k++] = nums[i];
            ans[k++] = nums[j];
        }
        return ans;
    }
}
