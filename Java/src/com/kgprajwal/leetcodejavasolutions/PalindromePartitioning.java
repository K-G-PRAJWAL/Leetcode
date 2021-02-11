package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        helper(ans, 0, new ArrayList<>(), s);
        return ans;
    }

    void helper(List<List<String>> ans, int start, List<String> tmp, String s) {
        if (start >= s.length()) ans.add(new ArrayList<>(tmp));
        for (int i = start; i < s.length(); i++) {
            if (checkPalindrome(s, start, i)) {
                tmp.add(s.substring(start, i + 1));
                helper(ans, i + 1, tmp, s);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    boolean checkPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
