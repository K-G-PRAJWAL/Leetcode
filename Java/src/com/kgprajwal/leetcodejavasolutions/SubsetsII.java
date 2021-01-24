package com.kgprajwal.leetcodejavasolutions;

import java.util.*;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        backtracker(nums, ans, new ArrayList<>(), 0);
        return ans;
    }

    void backtracker(int[] nums, List<List<Integer>> ans, List<Integer> temp, int index) {
        ans.add(new ArrayList<>(temp));
        Set<Integer> visited = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (visited.add(nums[i])) {
                temp.add(nums[i]);
                backtracker(nums, ans, temp, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        SubsetsII s = new SubsetsII();
        System.out.println(s.subsetsWithDup(new int[]{1, 2, 2}));
    }
}
