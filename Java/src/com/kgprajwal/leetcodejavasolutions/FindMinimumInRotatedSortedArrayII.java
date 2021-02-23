package com.kgprajwal.leetcodejavasolutions;

public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] > nums[h]) l = mid + 1;
            else if (nums[mid] < nums[l]) {
                h = mid;
                l++;
            } else h--;
        }
        return nums[l];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArrayII o = new FindMinimumInRotatedSortedArrayII();
        System.out.println(o.findMin(new int[]{1, 3, 5}));
    }
}
