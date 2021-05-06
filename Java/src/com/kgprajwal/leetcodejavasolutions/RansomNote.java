package com.kgprajwal.leetcodejavasolutions;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[26];
        for (int i = 0; i < magazine.length(); i++)
            cnt[magazine.charAt(i) - 'a']++;
        for (int j = 0; j < ransomNote.length(); j++) {
            if (--cnt[ransomNote.charAt(j) - 'a'] < 0) return false;
        }
        return true;
    }
}
