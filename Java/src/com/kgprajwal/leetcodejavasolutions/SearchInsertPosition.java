package com.kgprajwal.leetcodejavasolutions;

public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int l = 0, h = nums.length-1, mid;
        while(l<=h) {
            mid = (l+h)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target) h=mid-1;
            else l=mid+1;
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 5));
    }
}
