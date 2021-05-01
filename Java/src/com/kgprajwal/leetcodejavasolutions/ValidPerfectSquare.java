package com.kgprajwal.leetcodejavasolutions;

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int l = 1, r = num;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (mid * mid == num) return true;
            if (mid * mid < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
