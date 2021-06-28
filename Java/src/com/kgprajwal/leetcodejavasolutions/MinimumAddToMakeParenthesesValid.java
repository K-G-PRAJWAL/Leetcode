package com.kgprajwal.leetcodejavasolutions;

public class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        int required = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            required += s.charAt(i) == '(' ? 1 : -1;
            if (required == -1) {
                ans++;
                required++;
            }
        }
        return ans + required;
    }
}
