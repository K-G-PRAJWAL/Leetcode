package com.kgprajwal.leetcodejavasolutions;

import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int pos = points[0][1];
        int cnt = 1;
        for (int i = 1; i < points.length; i++) {
            if (pos >= points[i][0]) continue;
            cnt++;
            pos = points[i][1];
        }
        return cnt;
    }
}
