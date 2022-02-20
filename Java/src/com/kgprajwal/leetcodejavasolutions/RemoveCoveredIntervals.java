package com.kgprajwal.leetcodejavasolutions;

import java.util.Arrays;

public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        int ans = 0;
        int left = -1, right = -1;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int[] interval : intervals) {
            if (interval[0] > left && interval[1] > right) {
                left = interval[0];
                ++ans;
            }
            right = Math.max(right, interval[1]);
        }
        return ans;
    }
}
