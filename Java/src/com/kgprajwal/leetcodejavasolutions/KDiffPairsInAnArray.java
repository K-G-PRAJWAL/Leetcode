package com.kgprajwal.leetcodejavasolutions;

import java.util.HashMap;
import java.util.Map;

public class KDiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i] + k) && map.get(nums[i] + k) != i) {
                cnt++;
                map.remove(nums[i] + k);
            }
        }
        return cnt;
    }
}
