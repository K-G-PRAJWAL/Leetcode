package com.kgprajwal.leetcodejavasolutions;

public class JumpGame {
    public static boolean canJump(int[] nums) {
        int end = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= end) end = i;
        }
        return end == 0;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
    }
}
