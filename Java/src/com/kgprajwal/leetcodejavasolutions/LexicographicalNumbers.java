package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < 10; i++) dfs(i, n, ans);
        return ans;
    }

    void dfs(int curr, int n, List<Integer> ans) {
        if (curr > n) return;
        else {
            ans.add(curr);
            for (int i = 0; i < 10; i++) {
                if (curr * 10 + i > n) return;
                dfs(10 * curr + i, n, ans);
            }
        }
    }
}
