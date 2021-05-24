package com.kgprajwal.leetcodejavasolutions;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] cnt = new int[128];
        for (char ch : s.toCharArray()) cnt[ch]++;
        int ans = 0;
        for (int i : cnt) {
            ans += i / 2 * 2;
            if (ans % 2 == 0 && i % 2 == 1) ans++;
        }
        return ans;
    }
}
