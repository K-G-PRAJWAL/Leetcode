package com.kgprajwal.leetcodejavasolutions;

// O(S) (S = Sum of all characters in all strings)
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    // Driver
    public static void main(String[] args) {
        String[] s = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(s));
    }
}
