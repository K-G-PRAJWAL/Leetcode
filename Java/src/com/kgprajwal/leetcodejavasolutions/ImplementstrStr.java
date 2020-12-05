package com.kgprajwal.leetcodejavasolutions;

public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        int nL = needle.length();
        int hL = haystack.length();
        if(nL==0) return 0;
        if(hL==0) return -1;
        for(int i=0;i<hL;i++) {
            if(i+needle.length() > haystack.length()) break;
            for(int j=0;j<nL;j++) {
                if(haystack.charAt(i+j)!=needle.charAt(j)) break;
                if(j==nL-1) return i;
            }
        }
        return -1;
    }
}
