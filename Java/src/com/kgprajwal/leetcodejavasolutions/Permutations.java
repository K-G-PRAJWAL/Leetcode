package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, ans, new ArrayList<>());
        return ans;
    }

    private static void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> tmp) {
        if(tmp.size()==nums.length) ans.add(new ArrayList<>(tmp));
        else {
            for(int i=0;i<nums.length;i++) {
                if(tmp.contains(nums[i])) continue;
                tmp.add(nums[i]);
                backtrack(nums, ans, tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
    }
}
