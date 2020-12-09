package com.kgprajwal.leetcodejavasolutions;

// O(log N)
public class FindFirstandLastPositionofElementinSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        int start = find(nums, target, true);
        int end = find(nums, target, false);
        return new int[]{start, end};
    }

    private static int find(int[] nums, int target, boolean isFirst) {
        int ans = -1;
        int l=0,h=nums.length-1;
        while(l<=h) {
            int mid = (l+h)/2;
            if(nums[mid]==target) {
                ans = mid;
                if(isFirst) h=mid-1;
                else l=mid+1;
            } else if(nums[mid]<target) l=mid+1;
            else h=mid-1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        for (int i: searchRange(arr, 8))
            System.out.println(i);
    }
}
