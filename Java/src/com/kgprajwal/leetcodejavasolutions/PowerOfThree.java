package com.kgprajwal.leetcodejavasolutions;

public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}
