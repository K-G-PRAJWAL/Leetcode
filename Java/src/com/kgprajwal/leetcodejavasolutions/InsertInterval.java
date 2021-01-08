package com.kgprajwal.leetcodejavasolutions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new LinkedList<>();
        int i = 0;
        while(i < intervals.length && intervals[i][1] < newInterval[0]) {
            ans.add(intervals[i]);
            i++;
        }
        while(i<intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        ans.add(newInterval);
        while(i<intervals.length) {
            ans.add(intervals[i]);
            i++;
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        for(int[] i : insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8}))
        System.out.println(Arrays.toString(i));
    }
}
