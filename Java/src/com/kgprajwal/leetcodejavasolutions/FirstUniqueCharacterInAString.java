package com.kgprajwal.leetcodejavasolutions;

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int[] cnt = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            cnt[idx]++;
        }
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            if (cnt[idx] == 1) return i;
        }
        return -1;
    }
}
