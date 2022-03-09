package com.kgprajwal.leetcodejavasolutions;

public class ANumberAfterADoubleReversal {
    public boolean isSameAfterReversals(int num) {
        if (num > 0 && num % 10 == 0) return false;
        return true;
    }
}
