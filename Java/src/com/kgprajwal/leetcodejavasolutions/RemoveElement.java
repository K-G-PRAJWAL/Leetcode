package com.kgprajwal.leetcodejavasolutions;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int i = 0;
        while(i<n) {
            if(nums[i]==val) {
                nums[i] = nums[n-1];
                n--;
            } else i++;
        }
        return n;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElement(arr, val));
    }
}
