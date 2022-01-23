package com.kgprajwal.leetcodejavasolutions;

public class CountElementsWithStrictlySmallerAndGreaterElements {
    /*
    public int countElements(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            boolean leftCheck = false, rightCheck = false;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    leftCheck = true;
                    break;
                }
            }
            for (int k = i + 1; k < nums.length; k++) {
                if (nums[k] > nums[i]) {
                    rightCheck = true;
                    break;
                }
            }
            if (leftCheck && rightCheck) res++;
        }
        return res;
    }
    */

    // Simpler solution
    public int countElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > min && nums[i] < max) {
                res++;
            }
        }
        return res;
    }
}
