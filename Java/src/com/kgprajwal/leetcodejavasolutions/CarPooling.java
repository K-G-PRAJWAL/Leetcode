package com.kgprajwal.leetcodejavasolutions;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] length = new int[1001];
        for (int trip[] : trips) {
            length[trip[1]] += trip[0];
            length[trip[2]] -= trip[0];
        }
        for (int i : length) {
            capacity -= i;
            if (capacity < 0) return false;
        }
        return true;
    }
}
