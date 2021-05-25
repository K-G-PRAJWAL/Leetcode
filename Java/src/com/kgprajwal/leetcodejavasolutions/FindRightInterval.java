package com.kgprajwal.leetcodejavasolutions;

import java.util.Arrays;
import java.util.HashMap;

public class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = intervals.length;
        int m = intervals[0].length;
        int[] starts = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            map.put(starts[i], i);
        }
        Arrays.sort(starts);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int l = 0, r = n - 1;
            boolean found = false;
            int min = -1, ends = intervals[i][m - 1];
            while (l <= r) {
                int mid = (l + (r - l) / 2);
                if (starts[mid] >= ends) {
                    min = starts[mid];
                    found = true;
                    r = mid - 1;
                } else l = mid + 1;
            }
            ans[i] = found ? map.get(min) : -1;
        }
        return ans;
    }
}
