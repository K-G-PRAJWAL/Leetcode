package com.kgprajwal.leetcodejavasolutions;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) count[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']--;
            if (count[t.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }
}
