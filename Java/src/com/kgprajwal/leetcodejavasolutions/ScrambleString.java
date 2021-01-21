package com.kgprajwal.leetcodejavasolutions;

public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        int[] c = new int[26];
        for (int i = 0; i < len; i++) {
            c[s1.charAt(i) - 'a']++;
            c[s2.charAt(i) - 'a']--;
        }
        for (int i : c) {
            if (i != 0) return false;
        }
        if (len <= 3) return true;
        for (int i = 1; i <= s1.length() - 1; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if (isScramble(s1.substring(0, i), s2.substring(len - i)) && isScramble(s1.substring(i), s2.substring(0, len - i)))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ScrambleString s = new ScrambleString();
        System.out.println(s.isScramble("great", "rgeat"));
    }
}
