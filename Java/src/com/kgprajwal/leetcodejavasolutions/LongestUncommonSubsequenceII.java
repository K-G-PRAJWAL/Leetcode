package com.kgprajwal.leetcodejavasolutions;

public class LongestUncommonSubsequenceII {
    public int findLUSlength(String[] strs) {
        int ans = -1;
        int n = strs.length;
        for (int i = 0; i < n; i++) {
            if (strs[i].length() < ans) continue;
            int j = -1;
            while (++j < n)
                if (i != j && helper(strs[i], strs[j])) break;
            if (j == n) ans = Math.max(ans, strs[i].length());
        }
        return ans;
    }

    boolean helper(String a, String b) {
        int i = 0, j = 0;
        while (i < a.length() && j < b.length())
            if (a.charAt(i) == b.charAt(j++)) i++;
        return i == a.length();
    }
}
