package com.kgprajwal.leetcodejavasolutions;

public class MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] cntTops = new int[7], cntBottoms = new int[7], same = new int[7];
        int len = tops.length;

        for (int i = 0; i < len; i++) {
            int a = tops[i], b = bottoms[i];
            cntTops[a]++;
            cntBottoms[b]++;
            if (a == b) same[a]++;
        }

        int ans = len;
        for (int i = 1; i <= 6; i++) {
            if (cntTops[i] + cntBottoms[i] - same[i] == len) {
                return ans = len - Math.max(cntTops[i], cntBottoms[i]);
            }
        }
        return -1;
    }
}
