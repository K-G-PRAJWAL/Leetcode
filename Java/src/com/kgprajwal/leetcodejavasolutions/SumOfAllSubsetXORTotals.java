package com.kgprajwal.leetcodejavasolutions;

public class SumOfAllSubsetXORTotals {
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i : nums) ans |= i;
        return ans * (1 << n - 1);
    }
}
