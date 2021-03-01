package com.kgprajwal.leetcodejavasolutions;

public class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] num, int target) {
        int[] arr = new int[2];
        if (num == null || num.length < 2) return arr;
        int l = 0, r = num.length - 1;
        while (l < r) {
            int v = num[l] + num[r];
            if (v == target) {
                arr[0] = l + 1;
                arr[1] = r + 1;
                break;
            } else if (v > target) r--;
            else l++;
        }
        return arr;
    }
}
