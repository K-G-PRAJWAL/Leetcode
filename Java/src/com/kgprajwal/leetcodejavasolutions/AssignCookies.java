package com.kgprajwal.leetcodejavasolutions;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gIdx = 0, sIdx = 0, cnt = 0;
        while (gIdx < g.length && sIdx < s.length) {
            if (g[gIdx] <= s[sIdx]) {
                cnt++;
                gIdx++;
                sIdx++;
            } else sIdx++;
        }
        return cnt;
    }
}
