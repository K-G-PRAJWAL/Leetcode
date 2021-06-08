package com.kgprajwal.leetcodejavasolutions;

import java.util.List;
import java.util.stream.IntStream;

public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        int[] mins = timePoints.stream().mapToInt((s) -> {
            String[] value = s.split(":");
            return 60 * Integer.parseInt(value[0]) + Integer.parseInt(value[1]);
        }).sorted().toArray();
        int min = IntStream.range(0, mins.length - 1)
                .map(i -> mins[i + 1] - mins[i])
                .min()
                .getAsInt();
        int corner = mins[0] + (1440 - mins[mins.length - 1]);
        return Math.min(min, corner);
    }
}
