package com.kgprajwal.leetcodejavasolutions;

// O(N^2)
public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if(s==null || s.length()<1) return "";
        int start = 0, end = 0;
        for(int i=0;i<s.length();i++) {
            int l1 = expand(s, i, i);
            int l2 = expand(s, i, i+1);
            int l = Math.max(l1, l2);
            if(l>end-start) {
                start = i-(l-1)/2;
                end = i+l/2;
            }
        }
        return s.substring(start, end+1);
    }
    public static int expand(String s, int left, int right) {
        while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)) {
            left--; right++;
        }
        return right - left - 1;
    }

    // Driver
    public static void main(String[] args) {
        String s = "babad";
        String ans = longestPalindrome(s);
        System.out.println(ans);
    }
}
