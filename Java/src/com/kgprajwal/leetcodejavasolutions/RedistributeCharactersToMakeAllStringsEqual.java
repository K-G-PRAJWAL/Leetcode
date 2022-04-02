package com.kgprajwal.leetcodejavasolutions;

public class RedistributeCharactersToMakeAllStringsEqual {
    public boolean makeEqual(String[] words) {
        int[] freq = new int[26];
        for (String s : words) {
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                freq[ch - 'a']++;
            }
        }
        for (int cnt : freq) {
            if (cnt > 0 && cnt % words.length != 0) return false;
        }
        return true;
    }
}
