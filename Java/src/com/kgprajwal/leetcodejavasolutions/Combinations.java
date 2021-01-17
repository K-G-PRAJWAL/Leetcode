package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        Combinations s = new Combinations();
        System.out.println(s.combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backtracker(ans, new ArrayList<Integer>(), 1, n, k);
        return ans;
    }

    void backtracker(List<List<Integer>> ans, List<Integer> currComb, int start, int n, int k) {
        if (k == 0) {
            ans.add(new ArrayList<Integer>(currComb));
            return;
        }
        for (int i = start; i <= n; i++) {
            currComb.add(i);
            backtracker(ans, currComb, i + 1, n, k - 1);
            currComb.remove(currComb.size() - 1);
        }
    }
}
