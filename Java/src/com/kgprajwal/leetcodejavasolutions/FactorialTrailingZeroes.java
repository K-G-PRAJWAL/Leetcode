package com.kgprajwal.leetcodejavasolutions;

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        if (n == 0) return 0;
        return n / 5 + trailingZeroes(n / 5);
    }
}
