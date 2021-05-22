package com.kgprajwal.leetcodejavasolutions;

public class RotateFunction {
    public int maxRotateFunction(int[] nums) {
        int sum = 0, F = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            F += i * nums[i];
            sum += nums[i];
        }
        int max = F;
        for (int i = n - 1; i >= 1; i--) {
            F = F + sum - n * nums[i];
            max = Math.max(F, max);
        }
        return max;
    }
}
