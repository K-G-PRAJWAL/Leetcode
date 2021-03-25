package com.kgprajwal.leetcodejavasolutions;

public class KthLargestElementInAnArray {
    int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int lo, int hi, int k) {
        int i = lo, j = hi, pivot = nums[hi];
        while (i < j) {
            if (nums[i++] > pivot) swap(nums, --i, --j);
        }
        swap(nums, i, hi);
        if (i == k)
            return nums[i];
        else if (i > k)
            return quickSelect(nums, lo, i - 1, k);
        else
            return quickSelect(nums, i + 1, hi, k);
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
