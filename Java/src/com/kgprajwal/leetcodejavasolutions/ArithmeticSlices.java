package com.kgprajwal.leetcodejavasolutions;

public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        int curr = 0, sum = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                curr++;
                sum += curr;
            } else curr = 0;
        }
        return sum;
    }
}
