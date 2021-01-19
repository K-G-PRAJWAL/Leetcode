package com.kgprajwal.leetcodejavasolutions;

public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length, mid;
        while (start < end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] > nums[start]) {
                if (target < nums[mid] && target >= nums[start]) end = mid;
                else start = mid + 1;
            } else if (nums[mid] < nums[start]) {
                if (target > nums[mid] && target < nums[start]) start = mid + 1;
                else end = mid;
            } else start++;
        }
        return false;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArrayII s = new SearchInRotatedSortedArrayII();
        System.out.println(s.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
    }
}
