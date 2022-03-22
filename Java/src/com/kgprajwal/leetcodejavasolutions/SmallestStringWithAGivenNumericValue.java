package com.kgprajwal.leetcodejavasolutions;

import java.util.Arrays;

public class SmallestStringWithAGivenNumericValue {
    public String getSmallestString(int n, int k) {
        char[] ans = new char[n];
        Arrays.fill(ans, 'a');
        k -= n;

        while (n > 0 && k > 0) {
            int min = Math.min(k, 25);
            ans[--n] = (char) (min + 'a');
            k -= min;
        }

        return String.valueOf(ans);
    }
}
