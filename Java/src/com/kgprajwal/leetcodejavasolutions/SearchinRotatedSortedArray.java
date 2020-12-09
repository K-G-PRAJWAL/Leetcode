package com.kgprajwal.leetcodejavasolutions;

// O(log N)
public class SearchinRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, h = n-1, mid;
        while(l < h) {
            mid = (l+h)/2;
            if(nums[mid] > nums[h]) l = mid+1;
            else h = mid;
        }
        int pivot = l;
        l = 0; h = n-1;
        if(target>=nums[pivot] && target<=nums[h])  l = pivot;
        else h = pivot;
        while(l<=h) {
            mid = (l+h)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target) h = mid-1;
            else l=mid+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2};
        System.out.println(search(arr, 0));
    }
}
