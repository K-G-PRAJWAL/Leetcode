package com.kgprajwal.leetcodejavasolutions;

import java.util.HashSet;
import java.util.Set;
import java.lang.Math;

// O(N)
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int i=0, j=0;
        int n = s.length();
        Set<Character> set = new HashSet<>();
        while (i<n && j<n) {
            if(! set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                maxLen = Math.max(maxLen, j-i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return maxLen;
    }

    // Driver
    public static void main(String[] args) {
        String s = "abcabcbb";
        int ans = lengthOfLongestSubstring(s);
        System.out.println(ans);
    }
}
