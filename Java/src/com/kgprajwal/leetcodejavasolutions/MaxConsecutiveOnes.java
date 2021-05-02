package com.kgprajwal.leetcodejavasolutions;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currMax = 0;
        int finalMax = 0;
        for (int i : nums) {
            finalMax = Math.max(finalMax, currMax = i == 0 ? 0 : currMax + 1);
        }
        return finalMax;
    }
}
