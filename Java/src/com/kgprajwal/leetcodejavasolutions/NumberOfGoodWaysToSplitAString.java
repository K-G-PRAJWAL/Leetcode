package com.kgprajwal.leetcodejavasolutions;

import java.util.HashSet;
import java.util.Set;

public class NumberOfGoodWaysToSplitAString {
    public int numSplits(String s) {
        int n = s.length();
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        Set<Character> x = new HashSet<>();
        Set<Character> y = new HashSet<>();

        for (int i = 0; i < n; i++) {
            x.add(s.charAt(i));
            y.add(s.charAt(n - 1 - i));
            prefix[i] = x.size();
            suffix[n - 1 - i] = y.size();
        }

        int cnt = 0;
        for (int i = 1; i < n; i++) {
            if (prefix[i - 1] == suffix[i]) cnt++;
        }
        return cnt;
    }
}
