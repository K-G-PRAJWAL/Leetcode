package com.kgprajwal.leetcodejavasolutions;

public class MinimumMovesToEqualArrayElements {
    public int minMoves(int[] nums) {
        if (nums.length == 0) return 0;
        int min = nums[0];
        for (int i : nums) min = Math.min(i, min);
        int ans = 0;
        for (int i : nums) ans += (i - min);
        return ans;
    }
}
