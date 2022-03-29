package com.kgprajwal.leetcodejavasolutions;

public class DecryptStringFromAlphabetToIntegerMapping {
    public String freqAlphabets(String s) {
        String ans = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            String temp = "";
            if (s.charAt(i) == '#') {
                i = i - 2;
                temp = s.substring(i, i + 2);
            } else temp = "" + s.charAt(i);
            int ch = 96 + Integer.parseInt(temp);
            ans = (char) ch + ans;
        }
        return ans;
    }
}
