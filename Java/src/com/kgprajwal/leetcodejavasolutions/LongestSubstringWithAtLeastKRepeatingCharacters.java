package com.kgprajwal.leetcodejavasolutions;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        if (k < 2) return s.length();
        return helper(s, 0, s.length(), k);
    }

    int helper(String s, int l, int r, int k) {
        if (l >= r) return 0;
        final int low = r - l;
        char[] ch = s.toCharArray();
        int[] cnt = new int[26];
        for (int i = l; i < r; i++) cnt[s.charAt(i) - 'a']++;
        boolean check = true;
        int ans = 0;
        int start = l, end = l;
        while (end < l + low) {
            if (cnt[ch[end] - 'a'] < k) {
                ans = Math.max(ans, helper(s, start, end, k));
                check = false;
                start = end + 1;
            }
            end++;
        }
        return check ? low : Math.max(ans, helper(s, start, r, k));
    }
}
