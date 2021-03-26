package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, new ArrayList<Integer>(), k, 1, n);
        return ans;
    }

    void helper(List<List<Integer>> ans, List<Integer> temp, int k, int start, int n) {
        if (temp.size() == k && n == 0) {
            List<Integer> li = new ArrayList<Integer>(temp);
            ans.add(li);
            return;
        }
        for (int i = start; i <= 9; i++) {
            temp.add(i);
            helper(ans, temp, k, i + 1, n - i);
            temp.remove(temp.size() - 1);
        }
    }
