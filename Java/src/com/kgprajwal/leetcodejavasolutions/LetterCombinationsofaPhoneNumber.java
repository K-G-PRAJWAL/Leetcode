package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.List;

// O(3^n)
public class LetterCombinationsofaPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length()==0) return ans;
        String[] map= {
                "0",
                "1",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };
        recursive(ans, digits, "", 0, map);
        return ans;
    }

    public static void recursive(List<String> ans, String digits, String curr, int index, String[] map) {
        if(index==digits.length()) {
            ans.add(curr);
            return;
        }
        String letters = map[digits.charAt(index)-'0'];
        for(int i = 0; i < letters.length(); i++) {
            recursive(ans, digits, curr+letters.charAt(i), index+1, map);
        }
    }

    // Driver
    public static void main(String[] args) {
        String s = "23";
        System.out.println(letterCombinations(s));
    }
}
