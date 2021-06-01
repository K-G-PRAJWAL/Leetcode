package com.kgprajwal.leetcodejavasolutions;

import java.util.Arrays;

public class MatchsticksToSquare {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length == 0) return (false);
        int sum = 0;
        int[] buckets = new int[4];
        for (int i : matchsticks) sum += i;
        if (sum % 4 != 0) return (false);
        Arrays.sort(matchsticks);
        return (dfs(matchsticks, matchsticks.length - 1, buckets, sum / 4));
    }

    boolean dfs(int[] nums, int candidate, int[] buckets, int target) {
        if (candidate < 0) return (true);
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] += nums[candidate];
            if (buckets[i] <= target) {
                if (dfs(nums, candidate - 1, buckets, target))
                    return true;
            }
            buckets[i] -= nums[candidate];
        }
        return false;
    }
}
