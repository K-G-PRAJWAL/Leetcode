package com.kgprajwal.leetcodejavasolutions;

import java.util.Map;

public class BeautifulArray {
    Map<Integer, int[]> map;

    private int[] helper(int n) {
        if (map.containsKey(n)) return map.get(n);

        int[] ans = new int[n];
        if (n == 1) ans[0] = 1;
        else {
            int x = 0;
            for (int num : helper((n + 1) / 2)) ans[x++] = 2 * num - 1;
            for (int num : helper(n / 2)) ans[x++] = 2 * num;
        }
        map.put(n, ans);
        return ans;
    }

    public int[] beautifulArray(int n) {
        map = new HashMap<>();
        return helper(n);
    }
}
