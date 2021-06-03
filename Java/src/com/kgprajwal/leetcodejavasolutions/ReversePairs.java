package com.kgprajwal.leetcodejavasolutions;

public class ReversePairs {
    int[] arr;

    public int reversePairs(int[] nums) {
        this.arr = new int[nums.length];
        return mergeSort(nums, 0, nums.length - 1);
    }

    int mergeSort(int[] nums, int l, int r) {
        if (l >= r) return 0;
        int mid = l + (r - l) / 2;
        int count = mergeSort(nums, l, mid) + mergeSort(nums, mid + 1, r);
        for (int i = l, j = mid + 1; i <= mid; i++) {
            while (j <= r && nums[i] / 2.0 > nums[j]) j++;
            count += j - (mid + 1);
        }
        merge(nums, l, mid, r);
        return count;
    }

    void merge(int[] nums, int l, int mid, int r) {
        for (int i = l; i <= r; i++) arr[i] = nums[i];
        int ptr1 = l;
        int ptr2 = mid + 1;
        int i = l;
        while (ptr1 <= mid || ptr2 <= r) {
            if (ptr1 > mid || (ptr2 <= r && arr[ptr1] >= arr[ptr2])) nums[i++] = arr[ptr2++];
            else nums[i++] = arr[ptr1++];
        }
    }
}
