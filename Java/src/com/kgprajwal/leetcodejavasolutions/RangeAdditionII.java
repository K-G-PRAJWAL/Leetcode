package com.kgprajwal.leetcodejavasolutions;

public class RangeAdditionII {
    public int maxCount(int m, int n, int[][] ops) {
        int x = m, y = n;
        for (int[] op : ops) {
            x = Math.min(x, op[0]);
            y = Math.min(y, op[1]);
        }
        return x * y;
    }
}
