package com.kgprajwal.leetcodejavasolutions;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i=n-1;i>=0;i--) {
            if(digits[i]<9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] ans = new int[n+1];
        ans[0] = 1;
        return ans;
    }

    public static void main(String[] args) {
        int[] ans = plusOne(new int[]{1,2,3});
        for(int i : ans) System.out.println(i);
    }
}
