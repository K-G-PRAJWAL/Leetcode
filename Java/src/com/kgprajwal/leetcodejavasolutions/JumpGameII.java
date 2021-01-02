package com.kgprajwal.leetcodejavasolutions;

public class JumpGameII {
    public static int jump(int[] nums) {
        int cnt = 0;
        int pos = 0, des = 0;
        for(int i=0;i<nums.length-1;i++) {
            des = Math.max(des, i+nums[i]);
            if(pos==i) {
                pos = des;
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
    }
}
