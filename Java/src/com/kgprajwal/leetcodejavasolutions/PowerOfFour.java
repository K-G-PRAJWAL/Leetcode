package com.kgprajwal.leetcodejavasolutions;

public class PowerOfFour {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        double logValue = Math.log(n) / Math.log(4);
        return (logValue % 1) == 0;
    }
}
