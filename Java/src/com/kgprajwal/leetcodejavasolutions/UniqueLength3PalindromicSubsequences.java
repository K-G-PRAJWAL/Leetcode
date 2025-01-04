package com.kgprajwal.leetcodejavasolutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueLength3PalindromicSubsequences {
    public int countPalindromicSubsequence(String s) {
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);

        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            if (first[curr] == -1) first[curr] = i;
            last[curr] = i;
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (first[i] == -1) continue;

            Set<Character> middle = new HashSet<>();
            for (int j = first[i] + 1; j < last[i]; j++) {
                middle.add(s.charAt(j));
            }

            ans += middle.size();
        }

        return ans;
    }
}
