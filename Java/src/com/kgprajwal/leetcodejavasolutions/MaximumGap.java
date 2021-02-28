package com.kgprajwal.leetcodejavasolutions;

public class MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int exp = 1;
        int d = 10;
        int[] aux = new int[nums.length];
        while (max / exp > 0) {
            int[] count = new int[d];
            for (int i = 0; i < nums.length; i++) count[(nums[i] / exp) % 10]++;
            for (int i = 1; i < count.length; i++) count[i] += count[i - 1];
            for (int i = nums.length - 1; i >= 0; i--) aux[--count[(nums[i] / exp) % 10]] = nums[i];
            for (int i = 0; i < nums.length; i++) nums[i] = aux[i];
            exp *= 10;
        }
        int maximum = 0;
        for (int i = 1; i < aux.length; i++) maximum = Math.max(maximum, aux[i] - aux[i - 1]);
        return maximum;
    }
}
