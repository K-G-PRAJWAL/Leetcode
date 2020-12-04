package com.kgprajwal.leetcodejavasolutions;

public class RemoveDuplicatesFromSoretdArray {
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        int i = 0;
        for(int j=1;j<n;j++) {
            if(nums[i]!=nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        int ans = removeDuplicates(arr);
        System.out.println(ans);
    }
}
