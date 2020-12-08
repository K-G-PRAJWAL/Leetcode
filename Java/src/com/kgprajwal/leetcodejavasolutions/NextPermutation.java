package com.kgprajwal.leetcodejavasolutions;

// O(N)
public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        if(nums==null || n==0) return;
        int i = n - 2;
        while(i>=0 && nums[i]>=nums[i+1]) i--;
        if(i>=0) {
            int j = n - 1;
            while(j>=0 && nums[j]<=nums[i]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i+1, n-1);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void reverse(int[] arr, int i, int j) {
        while(i<j) swap(arr, i++, j--);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        nextPermutation(arr);
        for(int i: arr) System.out.println(i+" ");
    }
}
