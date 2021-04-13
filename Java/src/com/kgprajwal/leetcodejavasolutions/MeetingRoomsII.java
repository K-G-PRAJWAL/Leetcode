package com.kgprajwal.leetcodejavasolutions;

import java.util.Arrays;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] startTime = new int[n];
        int[] endTime = new int[n];
        int index = 0;
        for (int[] interval : intervals) {
            startTime[index] = interval[0];
            endTime[index++] = interval[1];
        }
        Arrays.sort(startTime);
        Arrays.sort(endTime);
        int i = 0, j = 0;
        int activate = 0, max = 0;
        while (i < n && j < n) {
            if (startTime[i] < endTime[j]) {
                activate++;
                i++;
            } else {
                activate--;
                j++;
            }
            max = Math.max(max, activate);
        }
        return max;
    }
}
