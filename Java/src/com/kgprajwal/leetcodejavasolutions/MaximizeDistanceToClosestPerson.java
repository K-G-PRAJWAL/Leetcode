package com.kgprajwal.leetcodejavasolutions;

public class MaximizeDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        if (seats == null || seats.length == 0) return -1;
        int n = seats.length;
        int l = -1, r = -1;
        int ans = 0;
        int i = 0;
        while (i < n) {
            while (i < n && seats[i] == 1) i++;
            l = i;
            while (i < n && seats[i] == 0) i++;
            r = i;
            if (l == 0 || r == n) ans = Math.max(ans, r - l);
            else ans = Math.max(ans, (int) Math.ceil((r - l) / 2.0));
        }
        return ans;
    }
}
