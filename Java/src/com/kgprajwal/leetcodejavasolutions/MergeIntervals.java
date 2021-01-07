package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
        List<int[]> ans = new ArrayList<>();
        int[] temp = intervals[0];
        ans.add(temp);
        for (int[] interval : intervals) {
            if (interval[0] <= temp[1])
                temp[1] = Math.max(temp[1], interval[1]);
            else {
                temp = interval;
                ans.add(temp);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        int[][] x = merge(new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        });
    }
}
