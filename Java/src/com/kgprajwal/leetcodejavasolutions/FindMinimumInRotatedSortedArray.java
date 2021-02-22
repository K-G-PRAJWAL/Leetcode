package com.kgprajwal.leetcodejavasolutions;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        int l = 0, r = nums.length - 1;
        if (nums[r] > nums[0]) return nums[0];
        while (r >= l) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] > nums[0]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray o = new FindMinimumInRotatedSortedArray();
        System.out.println(o.findMin(new int[]{3, 4, 5, 1, 2}));
    }
}
