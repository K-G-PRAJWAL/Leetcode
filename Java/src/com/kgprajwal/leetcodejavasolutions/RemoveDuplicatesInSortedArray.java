package com.kgprajwal.leetcodejavasolutions;

public class RemoveDuplicatesInSortedArray {
    public static void main(String[] args) {
        RemoveDuplicatesInSortedArray r = new RemoveDuplicatesInSortedArray();
        System.out.println(r.removeDuplicates(new int[]{1,1,1,2,2,3}));
    }

    public int removeDuplicates(int[] nums) {
        int i=0;
        for(int n: nums) {
            if(i<2 || n>nums[i-2]) nums[i++] = n;
        }
        return i;
    }
}
