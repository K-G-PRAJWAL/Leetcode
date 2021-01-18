package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> ans = new ArrayList<>();
//        ans.add(new ArrayList<>());
//        if(nums.length==0) return ans;
//        int l = 0;
//        for(int n : nums) {
//            l = ans.size();
//            for(int i=0;i<l;i++) {
//                List<Integer> subset = new ArrayList<>(ans.get(i));
//                subset.add(n);
//                ans.add(subset);
//            }
//        }
//        return ans;
//    }

    public static void main(String[] args) {
        Subsets s = new Subsets();
        System.out.println(s.subsets(new int[]{1,2,3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtracker(nums, ans, new ArrayList<>(), 0);
        return ans;
    }

    void backtracker(int[] nums, List<List<Integer>> ans, List<Integer> subset, int start) {
        ans.add(new ArrayList<>(subset));
        for(int i=start;i<nums.length;i++) {
            subset.add(nums[i]);
            backtracker(nums, ans, subset, i+1);
            subset.remove(subset.size()-1);
        }
    }
}
