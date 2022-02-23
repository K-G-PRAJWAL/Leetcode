package com.kgprajwal.leetcodejavasolutions;

import java.util.Arrays;

public class SortEvenAndOddIndicesIndependently {
    public int[] sortEvenOdd(int[] nums) {
        int n = nums.length;
        int[] oddArr = new int[(int) n / 2];
        int[] evenArr = new int[n - (int) n / 2];

        int evenIdx = 0, oddIdx = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) evenArr[evenIdx++] = nums[i];
            else oddArr[oddIdx++] = nums[i];
        }

        Arrays.sort(evenArr);
        Arrays.sort(oddArr);

        int l = 0;
        int r = oddArr.length - 1;
        for (int i = 0; i < n; i++)
            nums[i] = i % 2 == 0 ? evenArr[l++] : oddArr[r--];

        return nums;
    }
}
