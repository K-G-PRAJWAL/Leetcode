package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public void dfs(char[] charArr, List<String> ans, int idx) {
        if (idx == charArr.length) {
            ans.add(new String(charArr));
            return;
        }
        if (charArr[idx] >= '0' && charArr[idx] <= '9') {
            dfs(charArr, ans, idx + 1);
            return;
        }
        charArr[idx] = Character.toLowerCase(charArr[idx]);
        dfs(charArr, ans, idx + 1);
        charArr[idx] = Character.toUpperCase(charArr[idx]);
        dfs(charArr, ans, idx + 1);
    }

    public List<String> letterCasePermutation(String s) {
        if (s == null) return new ArrayList<String>();
        List<String> ans = new ArrayList<>();
        dfs(s.toCharArray(), ans, 0);
        return ans;
    }
}
