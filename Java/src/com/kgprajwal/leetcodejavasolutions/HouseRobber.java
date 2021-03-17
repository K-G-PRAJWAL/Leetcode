package com.kgprajwal.leetcodejavasolutions;

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int a = 0;
        int b = 0;
        for (int num : nums) {
            int tmp = a;
            a = Math.max(b + num, a);
            b = tmp;
        }
        return a;
    }
}
