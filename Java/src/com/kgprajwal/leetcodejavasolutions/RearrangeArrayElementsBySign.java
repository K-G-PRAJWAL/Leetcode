package com.kgprajwal.leetcodejavasolutions;

public class RearrangeArrayElementsBySign {
    /*
    public int[] rearrangeArray(int[] nums) {
        int[] ansArr = new int[nums.length];
        int[] poss = new int[nums.length / 2];
        int[] negs = new int[nums.length / 2];
        int posPtr = 0;
        int negPtr = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                poss[posPtr] = nums[i];
                posPtr++;
            } else {
                negs[negPtr] = nums[i];
                negPtr++;
            }
        }

        posPtr = 0;
        negPtr = 0;
        for (int i = 0; i < nums.length; i += 2) {
            ansArr[i] = poss[posPtr];
            posPtr++;
        }
        for (int i = 1; i < nums.length; i += 2) {
            ansArr[i] = negs[negPtr];
            negPtr++;
        }
        return ansArr;
    }
    */

    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int posIdx = 0;
        int negIdx = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans[posIdx] = nums[i];
                posIdx += 2;
            } else {
                ans[negIdx] = nums[i];
                negIdx += 2;
            }
        }
        return ans;
    }
}
