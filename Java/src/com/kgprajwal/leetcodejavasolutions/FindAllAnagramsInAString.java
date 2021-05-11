package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] hash = new int[256];
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return ans;
        for (char c : p.toCharArray()) hash[c]++;
        int l = 0, r = 0, cnt = p.length();
        while (r < s.length()) {
            if (hash[s.charAt(r++)]-- >= 1) cnt--;
            if (cnt == 0) ans.add(l);
            if (r - l == p.length() && hash[s.charAt(l++)]++ >= 0) cnt++;
        }
        return ans;
    }
}
