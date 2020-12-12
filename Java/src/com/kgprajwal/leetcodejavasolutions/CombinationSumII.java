package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        backtracker(candidates, temp, ans, target, 0);
        return ans;
    }

    private static void backtracker(int[] candidates, List<Integer> temp, List<List<Integer>> ans, int target, int start) {
        if(target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(target < 0) {
            return;
        }
        for(int i=start;i<candidates.length;i++) {
            if(i==start || candidates[i]!=candidates[i-1]) {
                temp.add(candidates[i]);
                backtracker(candidates, temp, ans, target - candidates[i], i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }
}
