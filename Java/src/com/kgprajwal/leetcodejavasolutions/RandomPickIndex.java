package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomPickIndex {
    private HashMap<Integer, List<Integer>> indices;
    private Random rand;

    public RandomPickIndex(int[] nums) {
        this.rand = new Random();
        this.indices = new HashMap<Integer, List<Integer>>();
        int l = nums.length;
        for (int i = 0; i < l; ++i) {
            if (!this.indices.containsKey(nums[i])) {
                this.indices.put(nums[i], new ArrayList<>());
            }
            this.indices.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        int l = indices.get(target).size();
        int randomIndex = indices.get(target).get(rand.nextInt(l));
        return randomIndex;
    }
}
