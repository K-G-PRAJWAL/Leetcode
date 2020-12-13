package com.kgprajwal.leetcodejavasolutions;

public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++) {
            int correctIdx = nums[i]-1;
            while(nums[i]>0 && nums[i]<=n && nums[i]!=nums[correctIdx]) {
                int temp = nums[i];
                nums[i] = nums[correctIdx];
                nums[correctIdx] = temp;
                correctIdx = nums[i]-1;
            }
        }
        for(int i=0;i<n;i++) {
            if(i+1!=nums[i]) return i+1;
        }
        return n+1;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1,2,0}));
    }
}
