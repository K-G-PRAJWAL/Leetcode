package com.kgprajwal.leetcodejavasolutions;

public class TrappingRainWater {
    public static int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n-1;
        int ans = 0;
        int leftMax = 0, rightMax = 0;
        while(left<=right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if(leftMax<=rightMax) {
                ans+=leftMax-height[left];
                left++;
            } else {
                ans+=rightMax-height[right];
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
