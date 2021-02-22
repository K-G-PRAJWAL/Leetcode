package com.kgprajwal.leetcodejavasolutions;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int currMax = 1, currMin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = currMax;
                currMax = currMin;
                currMin = tmp;
            }
            currMax = Math.max(nums[i], currMax * nums[i]);
            currMin = Math.min(nums[i], currMin * nums[i]);
            max = Math.max(max, currMax);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumProductSubarray o = new MaximumProductSubarray();
        System.out.println(o.maxProduct(new int[]{2, 3, -2, 4}));
    }
}
