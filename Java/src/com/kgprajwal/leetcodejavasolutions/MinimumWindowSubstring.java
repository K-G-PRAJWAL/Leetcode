package com.kgprajwal.leetcodejavasolutions;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        MinimumWindowSubstring m = new MinimumWindowSubstring();
        System.out.println(m.minWindow("ADOBECODEBANC", "ABC"));
    }

    public String minWindow(String s, String t) {
        int w1 = s.length();
        int w2 = t.length();
        if(w1==0 || w2==0) return "";
        String ans = "";
        int[] letterCounts = new int[128];
        int left = 0, count = 0, minLen = Integer.MAX_VALUE;
        for(char c: t.toCharArray()) {
            ++letterCounts[c];
        }
        for(int right=0;right<w1;right++) {
            if(--letterCounts[s.charAt(right)] >= 0) ++count;
            while(count==w2) {
                if(minLen>right-left+1) {
                    minLen = right-left+1;
                    ans = s.substring(left, right+1);
                }
                if(++letterCounts[s.charAt(left)] > 0) --count;
                ++left;
            }
        }
        return ans;
    }
}
