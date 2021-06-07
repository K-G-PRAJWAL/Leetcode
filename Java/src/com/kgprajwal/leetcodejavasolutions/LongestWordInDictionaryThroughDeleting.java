package com.kgprajwal.leetcodejavasolutions;

import java.util.List;

public class LongestWordInDictionaryThroughDeleting {
    /*public String findLongestWord(String s, List<String> dictionary) {
        String ans = "";
        for (String word : dictionary) {
            int i = 0;
            for (char ch : s.toCharArray()) {
                if (i < word.length() && ch == word.charAt(i)) i++;
            }
            if (i == word.length() && word.length() >= ans.length()) {
                if (word.length() > ans.length() || word.compareTo(ans) < 0) ans = word;
            }
        }
        return ans;
    }*/
    public String findLongestWord(String s, List<String> dictionary) {
        String ans = "";
        for (String word : dictionary) {
            if (helper(word, s)) {
                if (word.length() > ans.length()) ans = word;
                if (word.length() == ans.length() && word.compareTo(ans) < 0) ans = word;
            }
        }
        return ans;
    }

    boolean helper(String word, String s) {
        char wordArr[] = word.toCharArray();
        char sArr[] = s.toCharArray();
        int i = 0, j = 0;
        while (i < wordArr.length && j < sArr.length) {
            if (wordArr[i] == sArr[j]) i++;
            j++;
        }
        return i == wordArr.length;
    }
}
