package com.kgprajwal.leetcodejavasolutions;

public class BrokenCalculator {
    public int brokenCalc(int startValue, int target) {
        int step = 0;
        while (target > startValue) {
            if (target % 2 != 0) target += 1;
            else target /= 2;
            step++;
        }
        return step + startValue - target;
    }
}
