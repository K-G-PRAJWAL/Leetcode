package com.kgprajwal.leetcodejavasolutions;

public class BulbSwitcherII {
    public int flipLights(int n, int presses) {
        return Math.min(1 << Math.min(n, 3), 1 + presses * Math.min(n, 3));
    }
}
