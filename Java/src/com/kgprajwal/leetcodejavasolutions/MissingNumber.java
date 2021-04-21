package com.kgprajwal.leetcodejavasolutions;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int ans = nums.length * (nums.length + 1) / 2;
        int sum = 0;
        for (int num : nums)
            sum += num;
        return ans - sum;
    }
}
