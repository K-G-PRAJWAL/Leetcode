package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
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
        for(int i=start;i<candidates.length;i++) {
            if(candidates[i]>target) {
                break;
            }
            temp.add(candidates[i]);
            backtracker(candidates, temp, ans, target-candidates[i], i);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,6,7}, 7));
    }
}
