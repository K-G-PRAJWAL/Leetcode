package com.kgprajwal.leetcodejavasolutions;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int k = 0;
        int cnt = 1;
        int n = intervals.length;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= intervals[k][1]) {
                k = i;
                cnt++;
            }
        }
        return n - cnt;
    }
}
